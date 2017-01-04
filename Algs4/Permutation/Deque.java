import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {
    
    private Node<Item> first;
    private Node<Item> last;
    private int size;   
    
    public Deque() {    // construct an empty deque
        first = null;
        last = null;
        size = 0;
    }
    
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() { return new DequeIterator(first); }
      
    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> before;
    }
    
    private class  DequeIterator implements Iterator<Item> {
        
        private Node<Item> current;
        
        public DequeIterator(Node<Item> first) {
            current = first;
        }
        
        public boolean hasNext() { return current != null; }
        
        public void remove() { throw new UnsupportedOperationException(); }
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    

    public boolean isEmpty() {  // is the dqque empty?
        return first == null;
    }
    
    public int size() { // return the number of items on the deque
        return size;
    }
    
    public void addFirst(Item item) {   // add the item to the front
        if (item == null)
            throw new NullPointerException("null can not be added to deque");
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        first.before = null;        // is this statement really needed?
        if (oldfirst != null) oldfirst.before = first;
        size++;
        if (size == 1) last = first;
        
    }
    
    public void addLast(Item item) {    // add the item to the end
        if (item == null)
            throw new NullPointerException("null can not be added to deque");
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;       // is this statement really needed?
        if (oldlast != null) oldlast.next = last;
        last.before = oldlast;
        size++;
        if (size == 1) first = last;
        
    }
    
    public Item removeFirst() { // remove and return the item from the front
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        if (first != null) first.before = null;
        size--;
        if (size == 0) last = first;
        return item;
    }
    
    public Item removeLast() {  // remove and return the item from the end
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = last.item;
        last = last.before;
        if (last != null) last.next = null;
        size--;
        if (size == 0) first = last;
        return item;
    }
    
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) deque.addLast(item);
            else if (!deque.isEmpty()) StdOut.print(deque.removeFirst() + " ");
        }
        StdOut.println("(" + deque.size() + " left on deque");
    }    
}
