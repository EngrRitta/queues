/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

// public class RandomizedQueue<Item> implements Iterable<Item> {
public class RandomizedQueue<Item> {
    private int n;
    private int size;
    private Item[] queue;

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
        if (n >= size / 2) {
            Item[] tempData = queue;
            queue = (Item[]) new Object[size * 2];
            System.arraycopy(tempData, 0, queue, 0, n);
            size = size * 2;
        }
        queue[n] = item;
        n++;
    }

    // comment
    public Item dequeue() {
        StdRandom.shuffle(queue, 0, n);
        Item itemToReturn = queue[n - 1];
        queue[n - 1] = null;
        n--;
        return itemToReturn;
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> myQueue = new RandomizedQueue<Integer>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
