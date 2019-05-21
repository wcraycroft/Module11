/* HugeNumber.java - Modified Linked List from textbook with a sorted add method
 * Author:     Will Craycroft
 * Module:     11
 * Project:    HW 11 - Project 2
 * Description: Sorted Linked List
 *
 *      Instance variables
 *           Node head - points to first Node in list
 *
 *      Inner Classes
 *           Node
 *           Iterator
 *
 *      Methods:
 *           Default Constructor
 *           addDigit() - Adds next most-significant digit to head of the list
 *           reset() - clears the list, resetting the huge number
 *           toString() - prints the suitor of each student in the list
 *
 *      Modifications made:
 *        1) Limited generic parameter to only Comparable objects
 *        2) AddSorted method which iterates through the linked list until it finds a larger value, then creates a new
 *           node before that value.
 */

import java.util.NoSuchElementException;

public class HugeNumber {

    // Instance variable
    private Node head ;

    // Constructors
    public Iterator iterator() {
        return new Iterator() ;
    }
    public HugeNumber() {
        head = null ;                  // empty list
    }

    /***************************************************************
     * Adds a node at the start of the list with the specified data.
     * The added node will be the first node in the list.
     ***************************************************************/
    public void addDigit(int digit) {
        head = new Node(digit, head) ;
    }


    // Empty the list
    public String reset() {
        // Store number as String
        String returnString = toString();
        // Remove reference to linked list
        head = null ;
        // Return number
        return returnString;
    }


    // Returns all digits as a string (returns empty String if no links exist)
    public String toString() {

        String returnString = "" ;

        // Start at the front of the list
        Node position = head ;

        // Print each node
        if (head != null) {
            // Loop through digits (most significant to least) and append to return String
            while (position != null) {
                returnString += position.digit;   // ***** access digit directly *****
                position = position.link ;
            }
        }

        return returnString ;
    }


    /**
     * This inner class stores a suitor (int) and a link to the next Node in the list
     *
     *      Instance variables:
     *          int digit
     *          Node link
     */
    private class Node {

        private int digit;
        private Node link ;

        public Node() {
            digit = 0 ;
            link = null ;
        }
        public Node(int digit, Node link) {
            this.digit = digit;
            this.link = link ;
        }
    } // end of Node inner class

    /**
     * Iterator.java - provides the functionality needed to traverse the linked list
     *
     *      Instance variables:
     *          Node position - current position of iterator
     *          Node previous - node prior to node at position
     *
     *      Methods
     *          restart - sets position to head
     *          next - returns the current position and moves pointer to link
     *          hasNext - returns true if position link is not null
     */

    public class Iterator {
        private Node position ;
        private Node previous ;          //previous value of position

        public Iterator() {
            position = head ;            //Instance variable head of outer class.
            previous = null ;
        }

        public void restart() {
            position = head ;            //Instance variable head of outer class.
            previous = null ;
        }

        public int next() {
            if (!hasNext())
                throw new NoSuchElementException( ) ;

            int toReturn = position.digit;
            previous = position ;
            position = position.link ;
            return toReturn ;
        }

        public boolean hasNext() {
            return (position != null) ;
        }


    } // end of Iterator inner class
}



