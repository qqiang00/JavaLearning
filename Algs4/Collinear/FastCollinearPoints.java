import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class FastCollinearPoints {
    private Point[] points;
    private int numOfSeg;
    private LineSegment[] lines;
    
    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) 
            throw new NullPointerException("argument to the constructor is null");
        this.numOfSeg = 0;
        this.lines = new LineSegment[0];
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null)
                throw new NullPointerException("null point in array");
            this.points[i] = points[i];
        }
        Arrays.sort(this.points);
        // checking duplicated points after Arrays.sort() saves time.
        for (int i = 0; i < this.points.length - 1; i++) {
            if (this.points[i].compareTo(this.points[i+1]) == 0)
                throw new IllegalArgumentException("repeated point");
        }
        // find line segments
        // Do call this method in the constructor to meet the assignment requirements.
        this.findLineSegment();
    }
    private void findLineSegment() {
        this.numOfSeg = 0;
        int len = points.length;
        if (len < 4) return;
        // use ArrayList to dynamic add line segment.
        ArrayList<LineSegment> seg = new ArrayList<LineSegment>();
        for (int i = 0; i < len; i++) {
            Point p = this.points[i];   // all slope of possible lines are calculated
                                        // based on this current Point p.
            Point[] visitedPoints = new Point[i+1];     // points visited
            Point[] futurePoints = new Point[len-i];    // points not visited yet
            // p == futurePoint[0] == visitedPoints[i]
            for (int j = 0; j < len; j++) {
                if (j <= i) visitedPoints[j] = this.points[j];
                // futurePoints[j] = this.points[j];
                if (j >= i) futurePoints[j-i] = this.points[j];
            }
            // sort two arrays according to their slopes with origin point p.
            Arrays.sort(visitedPoints, p.slopeOrder());
            Arrays.sort(futurePoints, p.slopeOrder());
            // after sort: p == futurePoint[0] == visitedPoints[0]
            int k = 1;      // you can also start with k = 0
            double slope;
            while (k < futurePoints.length) {
                // if you change the condition to "k < futurePoints.length - 3",
                // some horizontal and vertical might not be found.
                slope = p.slopeTo(futurePoints[k]);
                int j;      // have no relation with local variable p above.
                for (j = k; j < futurePoints.length; j++) {
                    double slope1 = p.slopeTo(futurePoints[j]);
                    if (slope > slope1 || slope < slope1)   
                        // we don't use 'slope == slope1' as equal check with data type
                        // double is imprecise.
                        break;
                }
                // found a new line contains 4 or more points. 
                if (j - k >= 3 && !alreadyExist(visitedPoints, slope)) {   
                    LineSegment ls;
                    ls = new LineSegment(p, futurePoints[j-1]); 
                    seg.add(ls);
                    this.numOfSeg++;
                }
                k = j;                
            }            
        }
        // convert ArrayList to LineSegment[]
        lines = new LineSegment[this.numOfSeg];
        for (int i = 0; i < this.numOfSeg; i++) {
            lines[i] = seg.get(i);
        }
    }
    
    private boolean alreadyExist(Point[] visited, double slope) {
        double slope0;
        for (int i = 0; i < visited.length; i++) {
            // visited[0] equals current Point p
            slope0 = visited[0].slopeTo(visited[i]);
            // add this conditional statement to get 100/100 of score
            // otherwise it will be judged with a cubic or worse time costs.
            if (slope0 > slope) 
                return false;
            if (slope0 <= slope && slope0 >= slope)
                return true;
        }
        return false;
    }
    
    // the number of line segments
    public int numberOfSegments() {    
        return this.numOfSeg;
    }
    
    // the line segments
    public LineSegment[] segments() {
        // we need a data copy of private variable. 
        // directly expose private variable is not safe.
        return this.lines.clone();
    }
    
    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        // StdOut.println(n);
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
            // StdOut.println(p);
        }
        StdDraw.show();
        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            // StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
