import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/* Corner cases. 
 * By convention, the row and column indices are integers between 1 and n, where
 * (1, 1) is the upper-left site: Throw a java.lang.IndexOutOfBoundsException
 * if any argument to open(), isOpen(), or isFull() is outside its prescribed 
 * range. The constructor should throw a java.lang.IllegalArgumentException 
 * if n ≤ 0.
 * Performance requirements.  
 * The constructor should take time proportional to n2; all methods should take
 * constant time plus a constant number of calls to the union–find methods 
 * union(), find(), connected(), and count().
 */
public class Percolation {
    private boolean[][] siteState;  // false: blocked; true:open
    private int scale;    // store the argument n, 
    private int numOfOpenSites;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf2;   //specifically for isFull(int row, int col) function
    private int vTop, vBottom;
    
    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.siteState = new boolean[n][n];
        this.scale = n;
        this.numOfOpenSites = 0;
        // [n*n]: virtual top; [n*n+1]: virtual bottom
        this.uf = new WeightedQuickUnionUF(n*n+2);
        this.uf2 = new WeightedQuickUnionUF(n*n+1);
        this.vTop = n*n;
        this.vBottom = n*n+1;
        for (int row = 1; row <= n; row++)
            for (int col = 1; col <= n; col++)
                this.siteState[row-1][col-1] = false;
    }
    
    // return if argument row and col are in correct range
    private boolean isValidate(int row, int col) {
        return row >= 1 && row <= this.scale && col >= 1 && col <= this.scale;
    }
    
    // get index in UF according to its row col indexes in siteState
    private int to1dIndex(int row, int col) {
        return (row - 1) * this.scale + col - 1;
    }
    
    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!this.isValidate(row, col))
            throw new IndexOutOfBoundsException();
        if (!this.siteState[row-1][col-1]) {
            this.siteState[row-1][col-1] = true;
            this.numOfOpenSites += 1;
            int index = to1dIndex(row, col);
            if (row == 1) {
                uf.union(vTop, index);
                uf2.union(vTop, index);
            }
            if (row == scale) uf.union(vBottom, index);
            int[][] dp = { {0, -1}, {-1, 0}, {0, 1}, {1, 0} };
            for (int i = 0; i < 4; i++) {
                int neighborRow = row + dp[i][0];
                int neighborCol = col + dp[i][1];
                if (isValidate(neighborRow, neighborCol) 
                        && isOpen(neighborRow, neighborCol)) {
                    uf.union(index, to1dIndex(neighborRow, neighborCol));
                    uf2.union(index, to1dIndex(neighborRow, neighborCol));
                }
            }
        }
    }
    
    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!this.isValidate(row, col))
            throw new IndexOutOfBoundsException();
        return this.siteState[row-1][col-1];
    }
    
    // A full site is an open site that can be connected to an open site in the 
    // top row via a chain of neighboring (left, right, up, down) open sites.
    public boolean isFull(int row, int col) {
        if (!isValidate(row, col))
            throw new IndexOutOfBoundsException();
        // for first row, open is full
        int index = to1dIndex(row, col);
        return isOpen(row, col) && uf2.connected(vTop, index);
    }
    
    // numbers of open sites
    public int numberOfOpenSites() {
        return this.numOfOpenSites;
    }
    
    // percolates if there is a full site in the bottom row.
    public boolean percolates() {
        return uf.connected(vTop, vBottom);
    }
}
