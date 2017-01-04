import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] openRatio; // open / blocked ratio when whole grid is percolated.
    private int scale;  // width ( or height) of the grid.
    private int trials; // testing times
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("");
        this.openRatio = new double[trials];
        this.scale = n;
        this.trials = trials;
        this.runMonteCarloSimulation();
    }
    
    private void runMonteCarloSimulation(){
        Percolation pclt;
        int totalNums = scale*scale;
        int[] randOrder = new int[totalNums];
        for (int i = 0; i < totalNums; i++) {
            randOrder[i] = i;
        }
        int counter, row, col;
        for (int t = 0; t < trials; t++) {
            counter = totalNums - 1;
            pclt = new Percolation(scale);            
            StdRandom.shuffle(randOrder);
            while (!pclt.percolates() && counter >= 0) {
                col = randOrder[counter] % scale + 1; 
                row = randOrder[counter] / scale + 1;
                pclt.open(row, col);
                counter--;
            }
            this.openRatio[t] = pclt.numberOfOpenSites()/(1.0*totalNums);
        }        
    }
    
    public double mean() {
        return StdStats.mean(openRatio);
    }
    
    public double stddev() {
        return StdStats.stddev(openRatio);
    }
    
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(openRatio.length);
    }
    
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(openRatio.length);
    }
    
    public static void main(String[] args) {   
        if (args.length < 2)
            throw new IllegalArgumentException("2 arguments required.");
        int scale = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(scale, trials);
        StdOut.printf("mean                    = %7.6f\n", ps.mean());
        StdOut.printf("stddev                  = %.10f\n", ps.stddev());
        StdOut.printf("95%% confidence interval = %.10f, %.10f\n", 
                ps.confidenceLo(), ps.confidenceHi());              
    }
}
