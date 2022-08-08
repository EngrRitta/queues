/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String newString;
        RandomizedQueue<String> myQueue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            newString = StdIn.readString();
            myQueue.enqueue(newString);
        }
        for (int i = 0; i < k; i++) {
            System.out.println(myQueue.dequeue());
        }

    }
}
