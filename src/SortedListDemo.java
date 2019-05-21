/* SortedListDemo.java
 * Author:  William Craycroft
 * Module:  11
 * Project: HW 11 - Project 3
 * Problem Statement: Use a custom linked list to sort a collection of Comparable objects
 *
 * Algorithm / Plan:
 *      1. Instantiate 2 arrays of Strings and integers
 *      2. Instantiate linked lists
 *      3. Add values to linked list by adding to head
 *      4. Add values to linked list using sorted add method
 *          This method iterated through the linked list until it reaches a larger value, then inserts a new Node before that position
 *      5. Print sorted and unsorted linked lists
 */

import java.util.Arrays;

public class SortedListDemo {

    public static void main (String[] args) {
        // Declare int and string arrays (unsorted)
        int[] ints = {5, 12, 4, 9, 2, 1, 29, 53, 2, 7, 8};
        String[] strings = {"test", "unknown", "Bill", "today", "abracadabra", "boolean"};

        // Construct 4 linked lists using LinkedList3
        LinkedList3 intsUnsorted = new LinkedList3();
        LinkedList3 intsSorted = new LinkedList3();
        LinkedList3 stringsUnsorted = new LinkedList3();
        LinkedList3 stringsSorted = new LinkedList3();

        for (int value : ints) {
            intsUnsorted.addToStart(value);
            intsSorted.addSorted(value);
        }

        for (String value : strings) {
            stringsUnsorted.addToStart(value);
            stringsSorted.addSorted(value);
        }

        System.out.println("Original integers: " + Arrays.toString(ints));
        System.out.println("Original Strings: " + Arrays.toString(strings));
        System.out.println("\nUnsorted ints: ");
        intsUnsorted.outputList();
        System.out.println("\nSorted ints: ");
        intsSorted.outputList();
        System.out.println("\nUnsorted Strings: ");
        stringsUnsorted.outputList();
        System.out.println("\nSorted Strings: ");
        stringsSorted.outputList();


    } // end of main

}
