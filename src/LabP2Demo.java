/* LabDemo.java
 * Author:  William Craycroft
 * Module:  11
 * Project: Lab 11
 * Problem Statement: This class demonstrates the functionality of a LinkedList when used as a queue interface.
 *
 * Differences between offer() and add() methods:
 *      Both methods will attempt to add an object to the List. If the list is size restricted, offer() will return false,
 *      while add() will throw an IllegalStateException.
 *
 * Differences between poll() and remove():
 *      Both methods attempt to remove an item from the list. The only difference between then is that poll will return
 *      null if the queue is empty.
 *
 * Algorithm / Plan:
 *      1. Instantiate 5 Point objects
 *      2. Test the Constructor by instantiating a new LinkedList<Point>
 *      3. Add the 5 points to the queue using offer
 *      4. Instantiate a ListIterator and use it to print all elements in the queue using next()
 *      5. Use peek method to display the first element in the queue
 *      6. Loop through queue and use poll method to remove and print each item until the queue is empty (returns null)
 */


import java.util.LinkedList;
import java.util.ListIterator;

public class LabP2Demo {

    public static void main(String[] args)
    {
        // Instantiate 5 Point objects
        Point[] points = {new Point(71,92),
                new Point(9,6),
                new Point(5,12),
                new Point(0,1),
                new Point(2,2)};

        // Queue Demo

        // Instantiate queue
        LinkedList<Point> queue = new LinkedList<>();

        // offer
        for (Point point : points)
        {
            queue.offer(point);
        }

        // ListIterator
        ListIterator<Point> iterator = queue.listIterator();
        System.out.println("\nQueue printed using ListIterator:");
        while (iterator.hasNext())
        {
            System.out.print(iterator.next());
            // Add comma is list has another value
            if (iterator.hasNext())
                System.out.print(", ");
        }

        // peek
        System.out.println("\nFirst item in queue using peek: " + queue.peek());

        // poll
        System.out.println("\nQueue printed and deleted using poll:");
        while (queue.peek() != null)
        {
            System.out.print(queue.poll());
            // Add comma is list has another value
            if (queue.peek() != null)
                System.out.print(", ");
        }


    }
}
