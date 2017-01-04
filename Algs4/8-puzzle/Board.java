import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Board {
    private int n;              // board dimension n
    private int[][] tiles;      // tiles
    // private Position posBlank;  // index of blank tile (0) 
    // by using self defined Position class or use array int[] to store row and col
    // index it will simplify some codes, while can't pass the memory tests.
    private int blankRowIndex, blankColIndex;
    
    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        this.n = blocks.length;
        this.tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (blocks[i][j] == 0) { 
                    blankRowIndex = i;
                    blankColIndex = j;
                }
                this.tiles[i][j] = blocks[i][j];
            }
        }
    }
    /*
    private class Position {
        public int rowIndex, colIndex;

        public Position(int i, int j) {
            this.rowIndex = i;
            this.colIndex = j;
        } 
        
        public Position(Position pos) {
            this.rowIndex = pos.rowIndex;
            this.colIndex = pos.colIndex;
        }
        
        public void move(Position dpos) {
            this.rowIndex += dpos.rowIndex;
            this.colIndex += dpos.colIndex;
        }
    }
    */
    // board dimension n
    public int dimension() {
        return this.tiles.length;
    }
    
    // return the value of index [i][j] in goal board
    private int goalValue(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n)
            throw new IndexOutOfBoundsException("index out of bound");
        if (i == n - 1 && j == n - 1)
            return 0;
        return n * i + j + 1;
    }
    /*
    private int goalValue(Position pos) {
        return goalValue(pos.rowIndex, pos.colIndex);
    }
   
    private Position getGoalPosition(int value) {
        int n = this.tiles.length;
        if (value < 0 || value >= n*n)
            throw new IllegalArgumentException(String.
                    format("argument should be in [0,%d)",n*n));
        if (value == 0) return new Position(n-1, n-1);
        return new Position((value-1)/n, (value-1)%n);
    }
     */
    
    // return row index of a value in goal board
    private int goalRowIndex(int value) {
        if (value < 0 || value >= n*n)
            throw new IllegalArgumentException(String.
                    format("argument should be in [0,%d)", n*n));
        if (value == 0) return n-1;
        return (value-1) / n;        
    }
    
    // return col index of a value in goal board
    private int goalColIndex(int value) {
        if (value < 0 || value >= n*n)
            throw new IllegalArgumentException(String.
                    format("argument should be in [0,%d)", n*n));
        if (value == 0) return n-1;
        return (value-1) % n;        
    }
    
    
    // number of blocks out of place
    public int hamming() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) continue;
                if (tiles[i][j] != goalValue(i, j))
                    ans++;
            }
        }
        return ans;
    }
    
    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int ans = 0;
        int dis, value;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                value = tiles[i][j];
                if (value == 0) continue;
                dis = Math.abs(i - goalRowIndex(value)) + 
                        Math.abs(j - goalColIndex(value));
                ans += dis;
            }
        }
        return ans;        
    }
    
    // is this board the goal board?
    public boolean isGoal() {
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (tiles[i][j] != goalValue(i, j))
                    return false;
        return true;
    }
    // swap value of two positions in specific blocks
    /*
    private static void swapValue(Board board, Position p1, Position p2) {
        int[][] blocks = board.tiles;
        int tmp = blocks[p1.rowIndex][p1.colIndex];
        blocks[p1.rowIndex][p1.colIndex] = blocks[p2.rowIndex][p2.colIndex];
        blocks[p2.rowIndex][p2.colIndex] = tmp;
        if (tmp == 0) board.posBlank = board.new Position(p2);
        else if (blocks[p1.rowIndex][p1.colIndex] == 0)
            board.posBlank = board.new Position(p1);
    }
    */
    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        
        if (n == 1)
            return new Board(this.tiles);
        Board twinBoard = new Board(this.tiles);
        int v1, v2, x1, y1, x2, y2;
        int vBlank = goalValue(blankRowIndex, blankColIndex);
        do {
            v1 = StdRandom.uniform(n*n);
            v2 = StdRandom.uniform(n*n);
        } while (v1 == v2 || v1 == vBlank || v2 == vBlank);
        x1 = goalRowIndex(v1);
        y1 = goalColIndex(v1);
        x2 = goalRowIndex(v2);
        y2 = goalColIndex(v2);
        int tmp = twinBoard.tiles[x1][y1];
        twinBoard.tiles[x1][y1] = twinBoard.tiles[x2][y2];
        twinBoard.tiles[x2][y2] = tmp;
        return twinBoard;
    }
    
    // does this board equal y?
    public boolean equals(Object y) {
        
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        if (that.dimension() != n) return false;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (that.tiles[i][j] != this.tiles[i][j])
                    return false;
        return true;
    }
    
    // check if a position index is in correct range
    private boolean isValidPos(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < n)
            return true;
        return false;
    }
    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> queue = new Queue<Board>();
        int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < moves.length; i++) {
            int newBlankRowIndex = blankRowIndex + moves[i][0];
            int newBlankColIndex = blankColIndex + moves[i][1];
            if (isValidPos(newBlankRowIndex, newBlankColIndex)) {
                Board neighbor = new Board(this.tiles);
                int tmp = neighbor.tiles[blankRowIndex][blankColIndex];
                neighbor.tiles[blankRowIndex][blankColIndex] = 
                        neighbor.tiles[newBlankRowIndex][newBlankColIndex];
                neighbor.tiles[newBlankRowIndex][newBlankColIndex] = tmp;
                queue.enqueue(neighbor);
                neighbor.blankRowIndex = newBlankRowIndex;
                neighbor.blankColIndex = newBlankColIndex;
            }
        }
        return queue;
    }
    
    // string representation of this board (in the output format specified below)    
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    // call each public method of Board once
    private void test() {
        StdOut.println("========= test Board =============");
        StdOut.print("dimension: " + this.dimension()+ " ");
        StdOut.println(this);
        StdOut.println("Hamming: " + this.hamming());
        StdOut.println("Manhattan: " + this.manhattan());
        StdOut.println("is Goal: " + this.isGoal());
        StdOut.println("get a twin:");
        StdOut.println(this.twin());
        StdOut.println("Neighbors:");
        Queue<Board> iter = (Queue<Board>) this.neighbors();
        for (Board b:iter) {
            StdOut.println(b);
        }
        StdOut.println("===================================");
    }
    // unit tests (not graded)
    public static void main(String[] args) {
     // for each command-line argument
        for (String filename : args) {

            // read in the board specified in the filename
            In in = new In(filename);
            int n = in.readInt();
            int[][] tiles = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tiles[i][j] = in.readInt();
                }
            }
            // solve the slider puzzle
            Board initial = new Board(tiles);
            initial.test();
            // Solver solver = new Solver(initial);
            // StdOut.println(filename + ": " + solver.moves());
        }
    }
}
