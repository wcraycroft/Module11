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


    // Returns all digits as a string (-1 if empty)
    public String toString() {

        String returnString = "" ;

        // Start at the front of the list
        Node position = head ;

        // Print each node
        if (head == null) {
            // If empty, return -1
            returnString += "-1" ;
        } else {
            // Loop through digits (most significant to least) and append to return String
            while (position != null) {
                returnString += position.digit;   // ***** access digit directly *****
                position = position.link ;
            }
        }

        return returnString ;
    }


    /* Node.java -- inner class copied from Node class in LinkedListDemo project
     *
     *      Instance variables:
     *          String digit
     *          Node link
     *
     *      Methods
     *          Full constructor
     *          equals
     *          toString
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



