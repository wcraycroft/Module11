/* LabDemo.java
        * Author:  William Craycroft
        * Module:  11
        * Project: Lab 11
        * Problem Statement: This class demonstrates the functionality of a LinkedList when used to store Point objects.
        *
        * Algorithm / Plan:
        *      1. Instantiate 5 Point objects
        *      2. Test the Constructor by instantiating a new LinkedList<Point>
        *      3. Add the 5 points to the LinkedList using add, addFirst, addLast
        *      4. Remove 2 Points, using index and value parameters
        *      5. Test if a point is in the list using contains method
        *      6. Use indexOf to return the index of an existing Point in the list
        *      7. Return the number of elements in the list using size method
        *      8. Use toArray to convert the LinkedList into an Object[], then use Arrays class to convert it to Point[]
        *      9. Instantiate a ListIterator
        *      10. Loop through list using iterator until hasNext returns false. Print each list element using iterator.next()
        */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class LabDemo {

    public static void main (String[] args)
    {
        // Instantiate 5 Point objects
        Point[] points = {new Point(71,92),
                new Point(9,6),
                new Point(5,12),
                new Point(0,1),
                new Point(2,2)};

        // Linked List Demo
        // Constructor
        LinkedList<Point> pointLinkedList = new LinkedList<>();

        // add, addFirst, addLast
        pointLinkedList.add(points[0]);
        pointLinkedList.add(points[1]);
        pointLinkedList.add(points[2]);
        pointLinkedList.addFirst(points[3]);
        pointLinkedList.addLast(points[4]);

        System.out.println("After 5 Points were added:");
        System.out.println(pointLinkedList);

        // remove
        pointLinkedList.remove(2);
        pointLinkedList.remove(points[4]);

        System.out.println("\nAfter 2 Points were removed:");
        System.out.println(pointLinkedList);

        // contains
        System.out.println("\nDoes list contain Point(0, 1): " + pointLinkedList.contains(new Point(0, 1)));

        // indexOf
        System.out.println("\nThe index of Point(0, 1) is: " + pointLinkedList.indexOf(new Point(0, 1)));

        // size
        System.out.println("\nThe size of the array is: " + pointLinkedList.size());

        // toArray
        Point[] newArray = Arrays.stream(pointLinkedList.toArray()).toArray(Point[]::new);
        System.out.println("\nResulting array after toArray:");
        System.out.println(Arrays.toString(newArray));

        // ListIterator
        ListIterator<Point> iterator = pointLinkedList.listIterator();
        System.out.println("\nList printed using ListIterator:");
        while (iterator.hasNext())
        {
            System.out.print(iterator.next());
            // Add comma is list has another value
            if (iterator.hasNext())
                System.out.print(", ");
        }

    }
}
