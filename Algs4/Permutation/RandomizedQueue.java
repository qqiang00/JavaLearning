import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] q;           // queue elements
    private int n;              // number of elements on queue
    
    public RandomizedQueue() {
        q = (Item[]) new Object[2];
        n = 0;       
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public int size() {
        return n;
    }
    
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) 
            temp[i] = q[i];
        q = temp;
    }
    
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException("null can not be added to deque");
        if (n == q.length) resize(2*q.length);
        q[n++] = item;
    }
    
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int i = StdRandom.uniform(n);
        Item item = q[i];
        q[i] = q[n-1];
        q[n-1] = null;
        n--;
        if (n > 0 && n == q.length/4)   resize(q.length/2);
        return item;        
    }
    
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int i = StdRandom.uniform(n);
        return q[i];
    }
    
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
    
    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i;
        private Item[] c;
        
        public RandomizedQueueIterator() {
            i = n;
            c = (Item[]) new Object[i];
            for (int j = 0; j < i; j++) {
                c[j] = q[j];
            }
        }
        
        public boolean hasNext() {
            return i > 0;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int temp = StdRandom.uniform(i);
            Item item = c[temp];
            c[temp] = c[i-1];
            c[i-1] = item;
            i--;
            return item;
        }
    }
    
    public static void main(String[] args) {
        RandomizedQueue<String> rqueue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) rqueue.enqueue(item);
            else if (!rqueue.isEmpty()) StdOut.print(rqueue.dequeue() + " ");
        }
        StdOut.println("(" + rqueue.size() + " left on randomized queue");
    }
}
