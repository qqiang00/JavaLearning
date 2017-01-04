import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    
    public static void main(String[] args) {
        if (args.length < 1)
            throw new IllegalArgumentException("1 argument(k) required.");
        int k = Integer.parseInt(args[0]);
        if (k <= 0) { return; }
        RandomizedQueue<String> deque = new RandomizedQueue<String>();
        int cur = 0;
        int j;
        
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            cur++;
            if (cur <= k) {
                deque.enqueue(item);
            }
            else {
                j = StdRandom.uniform(cur) + 1;
                if (j <= k) {
                    deque.dequeue();
                    deque.enqueue(item);
                }
            }
        }
        for (String s : deque) {
            StdOut.println(s);
        }
    }
}
