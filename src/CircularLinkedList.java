/* CircularLinkedList.java - Circular Linked List of potential suitors identified by a unique number.
 * Author:     Will Craycroft
 * Module:     11
 * Project:    HW 11 - Project 1
 * Description: Eve's Suitors
 *
 *      Instance variables
 *           Node head
 *
 *      Inner Classes
 *           Node
 *
 *      Methods:
 *           No-argument Constructor
 *           addToStart() - adds a node to the start of the list
 *           deleteFromstart() - deletes node at the start of the list and
 *                               returns the deleted node
 *           isEmpty() - returns true if the list has no elements
 *           clear() - deletes all nodes in the list
 *           size() - returns the number of nodes in the list
 *           indexOf() - returns the index of the mode containing the student
 *                      suitor passed as a parameter
 *           contains() - returns true if the suitor of a student matches the
 *                        parameter to this method
 *           equals() - returns true if the size of the
 *           toString() - prints the suitor of each student in the list
 *
 *  Discussion Items:
 *    * Changes from original versions:
 *       * Removed all getters and setters (except setSuitor) in Node class
 *       * Accessed a Node's instance variables directly in LinkedList class
 *       * Made the Node class private
 */


import java.util.NoSuchElementException;

public class CircularLinkedList {

    private Node head ;                    // the head node of the list
    private Iterator iterator;            // iterator tracking the suitor you are currently counting from
    private int size;

    // No-argument constructor initializes the list to empty
    public CircularLinkedList() {
        head = null;
        iterator = new Iterator();
        size = 0;
    }

    /***************************************************************
     * Adds a node at the end of the list with the specified data.
     * The added node will be the last node in the list.
     ***************************************************************/
    public void append(int newSuitor)
    {
        // If first item in list...
        if (head == null)
        {
            head = new Node(newSuitor, null);
            head.link = head;
            // Start iterator at head
            iterator.restart();
            size++;
            return;
        }
        Node position = head;
        // Loop until last item item in list (points back to head)
        while (position.link != head)
        {
            position = position.link;
        }
        // Add new node, link back to head
        position.link = new Node(newSuitor, head);
        size++;
    }

    /**
     * Removes the next suitor by skipping 2 suitors, removing the 3rd suitor, and then pointing to the next suitor.
     * Returns the number of the suitor that was removed.
     */
    public int removeNextSuitor() {
        // If only 1 suitor remains, he is the winner and should not be removed. Use clear() method to remove last suitor.
        if (size <= 1) {
            return -1;
        }

        // Move the iterator over 2 Nodes
        iterator.next();
        iterator.next();
        // Delete node and return the suitor
        size--;
        return iterator.delete();
    }


    // Returns the number of the current suitor you are counting from.
    public int getCurrentSuitor()
    {
        return iterator.position.suitor;
    }

    // Returns the current size of the linked list
    public int size() {
        return size;
    }

    // Empty the list
    public void clear() {
        head = null ;                 // garbage collection will reclaim the space
        size = 0;
    }

    // returns the index of the suitor of a student, or -1 if not found
    public int indexOf(int suitor) {

        // Start at the beginning
        Node position = head ;
        int count = 0 ;

        // Traverse the list looking for the first occurrence of the suitor
        while (position.link != head) {
            if (suitor == position.suitor) {    // ***** access link directly *****
                return count ;
            }
            position = position.link ;           // ***** access link directly *****
            count++ ;
        }

        return -1 ;                      // not found
    }

    // returns true if the list contains the suitor passed as a parameter
    public boolean contains(int suitor) {
        return (indexOf(suitor) >= 0) ;
    }


    // print the suitors in this list
    public String toString() {

        String returnString = "" ;

        // Start at the front of the list
        Node position = head ;

        // Print each node
        if (head == null) {
            returnString += "(none)" ;
        } else {
            for (int i = 0; i < size; i++) {
                returnString += position.suitor + " " ;
                position = position.link ;
            }
        }

        return returnString ;
    }

    // equals verifies that the suitors in this list are all in the other list
    public boolean equals(Object anObject) {
        if (anObject == null || getClass() != anObject.getClass()) {
            return false ;
        }

        CircularLinkedList anotherList = (CircularLinkedList) anObject ;

        // Start at the front of the this list
        Node position = head ;

        // Make sure every suitor in this list is also in the other list
        while (position.link != head) {
            if (! anotherList.contains(position.suitor)) { // ***** access suitor directly *****
                return false ;
            }
            position = position.link ;                   // ***** access link directly *****
        }
        return true ;                                    // found them all!
    }


    /* Node.java -- inner class copied from Node class in LinkedListDemo project
     *
     *      Instance variables:
     *          String suitor
     *          Node link
     *
     *      Methods
     *          Full constructor
     *          setters and getters   <-  removed in this version (except setSuitor)
     *          equals
     *          toString
     */

    private class Node {

        // Instance variables
        private int suitor;            // unique number identifying the suitor
        private Node link ;            // link to next suitor

        // Full constructor
        public Node(int newSuitor, Node linkValue) {
            suitor = newSuitor ;
            link = linkValue ;
        }

        // toString returns the student's suitor on this node
        public String toString() {
            return (suitor == 0 ? "(no suitor)" : String.valueOf(suitor)) ;
        }

        // equals compares the suitor id's on two nodes
        public boolean equals(Object anObject) {
            if (anObject == null || getClass() != anObject.getClass()) {
                return false ;
            }
            Node aNode = (Node) anObject ;
            return (suitor == aNode.suitor) ;       // ***** access suitor directly *****
        }
    } // end of Node inner class


    /* Iterator.java -- an (inner) iterator class
     *
     *      Instance variables:
     *          Node position - current position of iterator
     *          Node previous - node prior to node at position
     *
     *      Methods (all are public)
     *          Full constructor
     *          restart
     *          next
     *          hasNext
     *          peek
     *          add
     *          change
     *          delete
     *          equals and toString() are not implemented
     *
     *   Can throw a NoSuchElementException if trying to change or delete an
     *   element at a non-existant position
     *
     *   Can thrown an IllegalStateException if trying to peek at the next
     *   element in the list if none exists
     *
     *   Note: If any changes are made to a list, then the calling program should
     *         restart any iterators on that list
     */
    public class Iterator {
        private Node position;
        private Node previous;          //previous value of position

        public Iterator() {
            position = head;            //Instance variable head of outer class.
            previous = null;
        }

        public void restart() {
            position = head;            //Instance variable head of outer class.
            previous = null;
        }

        public int next() {
            if (!hasNext())
                throw new NoSuchElementException();

            int toReturn = position.suitor;
            previous = position;
            position = position.link;
            return toReturn;
        }

        public boolean hasNext() {
            return (position != null);
        }

        /**
        Deletes the node at location position and
        moves position to the "next" node.
        Throws an IllegalStateException if the list is empty.
                */
        public int delete() {

            // If the is empty, then thrown an exception
            if (position == null)
                throw new IllegalStateException();

            int returnValue = position.suitor;
            // If at the head, be sure to reassign head to the new link
            if (position == head) {
                previous.link = position.link ;
                position = position.link ;
                head = position;

                // Otherwise remove the link at position
            } else {
                previous.link = position.link ;
                position = position.link ;
            }
            return returnValue;
        }

    } // end of Iterator inner class

}
