import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;


public class BruteCollinearPoints {
    
    private Point[] points;
    private LineSegment[] lines;
    private int numOfSeg;
    
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
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
        for (int i = 0; i < this.points.length - 1; i++) {
            if (this.points[i].compareTo(this.points[i+1]) == 0)
                throw new IllegalArgumentException("repeated point");
        }
        // find line segments containing 4 points
        this.findLineSegment();
    }
    
    private void findLineSegment() {
        this.numOfSeg = 0;
        int len = points.length;
        if (len < 4)
            return;
        ArrayList<LineSegment> seg = new ArrayList<LineSegment>();
        Point p, q, r, s;
        double slp1, slp2, slp3;
        for (int i = 0; i < len - 3; i++) {
            p = points[i];
            for (int j = i + 1; j < len - 2; j++) {
                q = points[j];
                slp1 = p.slopeTo(q);
                for (int k = j + 1; k < len - 1; k++) {
                    r = points[k];
                    slp2 = q.slopeTo(r);
                    for (int l = k + 1; l < len; l++) {
                        s = points[l];
                        slp3 = r.slopeTo(s);
                        if (slp2 >= slp3 && slp2 <= slp3 
                                && slp1 >= slp2 && slp1 <= slp2) {
                            LineSegment ls = new LineSegment(p, s);
                            this.numOfSeg++;
                            seg.add(ls);
                        }
                    }
                }
            }
        }
        // StdOut.println("number of Collinears: " + this.numOfSeg);
        this.lines = new LineSegment[this.numOfSeg];
        for (int i = 0; i < this.numOfSeg; i++) {
            lines[i] = seg.get(i);
        }
    }
    // the number of line segments
    public int numberOfSegments() {
        return this.numOfSeg;
    }

    // the line segments
    public LineSegment[] segments() {
        /* LineSegment[] copy = new LineSegment[this.lines.length];
        for (int i = 0; i < this.lines.length; i++) {
            copy[i] = this.lines[i];
        }
        return copy;
        */
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        // LineSegment[] segs = collinear.segments();
        // StdOut.println("numofSegments: " + segs.length);
        for (LineSegment segment : collinear.segments()) {
            // StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
