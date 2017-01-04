import java.util.ArrayList;
import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.MinPQ;

public class Solver {
    
    private int moves;
    private Board initial;              // initial Board node.
    private GameNode goalNode;
    private boolean isSolvable;         // whether initial is solvable.
  
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) 
            throw new NullPointerException("null initial puzzle board");
        this.initial = initial;
        goalNode = null;
        this.isSolvable = true;
        this.moves = 0;
        this.solve();
    }
    
    private class GameNode {
        private Board board;
        private int moves;
        private GameNode preNode;
        
        public GameNode(Board b, int moves, GameNode pre) {
            this.board = b;
            this.moves = moves;
            this.preNode = pre;
        }
        
        public GameNode(Board b, int moves) {
            this.board = b;
            this.moves = moves;
            this.preNode = null;
        }
        
        public int hamming() {
            return board.hamming() + moves;
        }
        
        public int manhattan() {
            return board.manhattan() + moves;
        }
    }
    
    // comparator<Board> class using Manhattan distance    
    private static class ByManhattan implements Comparator<GameNode> {
        public int compare(GameNode v, GameNode w) {
            Integer hv = (Integer)v.manhattan();
            Integer hw = (Integer)w.manhattan();
            return hv.compareTo(hw);
        }
    }

    // comparator<Board> class using Hamming distance
    private static class ByHamming implements Comparator<GameNode> {
        public int compare(GameNode v, GameNode w) {
            Integer hv = (Integer)v.hamming();
            Integer hw = (Integer)w.hamming();
            return hv.compareTo(hw);
        }
    }
    
 // solve initial and its twin simultaneously. if one is solved,
    // the other is unsolvable.
    private void solve() {
        // Board twin = this.initial.twin();
        if (initial.isGoal()) {
            this.isSolvable = true;
            this.moves = 0;
            this.goalNode = new GameNode(this.initial,0);
            return;
        }
        this.moves = 0;
        MinPQ<GameNode> pq = new MinPQ<GameNode>(new ByManhattan());
        MinPQ<GameNode> pqTwin = new MinPQ<GameNode>(new ByManhattan());
        
        // It's better to use a list to store all searched node to save time,
        // although searching a searched node may cost more time.
        // Board searchedBoard = null;
        // Board searchedTwinBoard = null;
        ArrayList<Board> searchedBoards = new ArrayList<Board>();
        ArrayList<Board> searchedTwinBoards = new ArrayList<Board>();
        
        Board twin = initial.twin();

        
        pq.insert(new GameNode(initial, this.moves));
        pqTwin.insert(new GameNode(twin, this.moves));
        GameNode curNode = pq.delMin();
        GameNode curTwinNode = pqTwin.delMin();
                
        boolean initialSolved = false;
        boolean twinSolved = false;
        while (!initialSolved && !twinSolved) {
            this.moves++;
            for(Board n : curNode.board.neighbors()){
                boolean found = false;
                for (Board s : searchedBoards){
                   if (n.equals(s)) {
                        found = true;
                        break;
                    }                    
                 }
                if (!found){
                    pq.insert(new GameNode(n, this.moves, curNode));
                }
            }
            searchedBoards.add(curNode.board);
            curNode = pq.delMin();
            this.moves = curNode.moves;
           
            for(Board n : curTwinNode.board.neighbors()){
                boolean found = false;
                for (Board s : searchedTwinBoards){
                    if (n.equals(s)) {
                        found = true;
                        break;
                    }                    
                }
                if (!found) {
                    pqTwin.insert(new GameNode(n, this.moves, curTwinNode));
                }
            }
            searchedTwinBoards.add(curTwinNode.board);
            // searchedTwinBoard = curTwinNode.board;
            
            curTwinNode = pqTwin.delMin();
            initialSolved = curNode.board.isGoal();
            twinSolved = curTwinNode.board.isGoal();
        }
        if (initialSolved) {
            this.goalNode = curNode;   
            this.moves = curNode.moves;
            this.isSolvable = true;
        }
        else {
            this.goalNode = null;
            this.moves = -1;
            this.isSolvable = false;
        }
    }
    
    // is the initial board solvable?
    public boolean isSolvable() {
        return this.isSolvable;
    }
    
    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return this.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!this.isSolvable)
            return null;
        Stack<Board> slt = new Stack<Board>();
        GameNode curNode = this.goalNode;
        while (curNode != null){
            slt.push(curNode.board);
            curNode = curNode.preNode;
        }
        return slt;
    }
    
    // solve a slider puzzle (given below)
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
