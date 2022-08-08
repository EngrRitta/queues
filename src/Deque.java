import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    // public class Deque<Item> {
    private int n; // size of deque
    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    // comment
    public Deque() {
        n = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null.");
        }
        if (n <= 0) {
            first = new Node();
            first.previous = null;
            first.next = null;
            last = first;
            first.item = item;
            n++;
        }
        else {
            Node oldfirst = first;
            first = new Node();
            oldfirst.previous = first;
            first.previous = null;
            first.next = oldfirst;
            first.item = item;
            n++;
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null.");
        }
        if (n <= 0) {
            last = new Node();
            last.previous = null;
            last.next = null;
            first = last;
            last.item = item;
            n++;
        }
        else {
            Node oldlast = last;
            last = new Node();
            oldlast.next = last;
            last.next = null;
            last.previous = oldlast;
            last.item = item;
            n++;
        }
    }

    public Item removeLast() {
        if (n <= 0) {
            throw new NoSuchElementException("The deque is empty.");
        }
        Item poppedItem;
        if (n == 1) {
            poppedItem = last.item;
            first = null;
            last = null;
            n--;
            return poppedItem;
        }
        else {
            poppedItem = last.item;
            last.previous.next = null;
            last = last.previous;
            n--;
            return poppedItem;
        }
    }

    public Item removeFirst() {
        if (n <= 0) {
            throw new NoSuchElementException("The deque is empty.");
        }
        Item poppedItem;
        if (n == 1) {
            poppedItem = first.item;
            first = null;
            last = null;
            n--;
            return poppedItem;
        }
        else {
            poppedItem = first.item;
            first.next.previous = null;
            first = first.next;
            n--;
            return poppedItem;
        }
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        Deque<Integer> myDeck = new Deque<Integer>();
        myDeck.addLast(1);
        myDeck.addLast(2);
        myDeck.addLast(3);
        myDeck.addLast(4);
        // System.out.println(myDeck.removeFirst());
        // System.out.println(myDeck.removeFirst());
        // System.out.println(myDeck.removeFirst());
        // System.out.println(myDeck.removeFirst());
        // Iterator<Integer> itr = myDeck.iterator();

        for (int item : myDeck) {
            System.out.println(item);

        }
    }
}
