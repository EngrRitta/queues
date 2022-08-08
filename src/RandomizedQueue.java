/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // public class RandomizedQueue<Item> {
    private int n;
    private int size;
    private Item[] queue;
    private boolean havePushed;

    public RandomizedQueue() {
        size = 1;
        queue = (Item[]) new Object[size];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item is null.");
        }
        if (n >= size / 2) {
            Item[] tempData = queue;
            queue = (Item[]) new Object[size * 2];
            System.arraycopy(tempData, 0, queue, 0, n);
            size = size * 2;
        }
        queue[n] = item;
        havePushed = true;
        n++;
    }

    // comment
    public Item dequeue() {
        if (n <= 0) {
            throw new NoSuchElementException("The queque is empty.");
        }
        if (n <= size / 4) {
            Item[] tempData = queue;
            queue = (Item[]) new Object[size / 2];
            System.arraycopy(tempData, 0, queue, 0, n);
            size = size / 2;
        }
        if (havePushed) {
            StdRandom.shuffle(queue, 0, n);
        }
        Item itemToReturn = queue[n - 1];
        queue[n - 1] = null;
        n--;
        havePushed = false;
        return itemToReturn;
    }

    public Item sample() {
        if (n <= 0) {
            throw new NoSuchElementException("The queque is empty.");
        }
        Item itemToReturn = queue[StdRandom.uniform(0, n)];
        return itemToReturn;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private int current = n;

        private Item[] queueCopy = (Item[]) new Object[n + 1];

        QueueIterator() {
            System.arraycopy(queue, 0, queueCopy, 0, n);
            StdRandom.shuffle(queueCopy, 0, n);
        }

        public boolean hasNext() {
            return current >= 1;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = queueCopy[current - 1];
            current--;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }


    public static void main(String[] args) {
        RandomizedQueue<Integer> myQueue = new RandomizedQueue<Integer>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);

        for (int a : myQueue) {
            for (int b : myQueue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }

        // Iterator<Integer> itr = myQueue.iterator();
        // for (int item : myQueue) {
        //    System.out.println(item);

        //}

        // Iterator<Integer> itr2 = myQueue.iterator();
        // for (int item : myQueue) {
        //    System.out.println(item);
        //}
        System.out.println(myQueue.sample());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        // System.out.println(myQueue.dequeue());
    }
}
