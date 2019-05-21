/* LinkedList3.java - Modified Linked List from textbook with a sorted add method
 * Author:     Will Craycroft / Textbook
 * Module:     11
 * Project:    HW 11 - Project 2
 * Description: Sorted Linked List
 *
 *      Instance variables
 *           Node head - points to first Node in list
 *
 *      Inner Classes
 *           Node
 *
 *      Methods:
 *           Default Constructor
 *           addToStart() - Adds a Node to the start of the list
 *           addSorted() - Adds an item to its ordered position in the list.
 *           append() - Adds a node at the end fo the list
 *           removeNextSuitor() - skips 2 suitors and removes the next
 *           getCurrentSuitor() - returns the suitor at current position
 *           size() - returns the number of nodes in the list
 *           indexOf() - returns the index of the mode containing the student suitor passed as a parameter
 *           contains() - returns true if the suitor of a student matches the parameter to this method
 *           equals() - returns true if the size of the
 *           toString() - prints the suitor of each student in the list
 *
 *      Modifications made:
 *        1) Limited generic parameter to only Comparable objects
 *        2) AddSorted method which iterates through the linked list until it finds a larger value, then creates a new
 *           node before that value.
 */



public class LinkedList3<T extends Comparable<T>>
{
    private class Node<T>
    {
        private T data;
        private Node<T> link;

        public Node( )
        {
             data = null;
             link = null;
        }

        public Node(T newData, Node<T> linkValue)
        {
            data = newData;
            link = linkValue;
        }
     }//End of Node<T> inner class

    private Node<T> head;

    public LinkedList3( )
    {
        head = null;
    }

    /**
     Adds a node at the start of the list with the specified data.
     The added node will be the first node in the list.
    */
    public void addToStart(T itemData)
    {
        head = new Node<T>(itemData, head);
    }


    /**********************************************************
     *    Added method (Project 3)
     **********************************************************/

    /**
     * Adds an item to its ordered position in the list.
     * @param itemData
     */
    public void addSorted(T itemData)
    {
        // Condition to insert at head of list (null or lower value than head)
        if (head == null || itemData.compareTo(head.data) < 0)
        {
            // Add to start
            head = new Node<T>(itemData, head);
        }
        else {

            Node<T> position = head;

            // Iterate through list until a large value is found
            while (position.link != null && position.link.data.compareTo(itemData) < 0) {
                position = position.link;
            }

            // Insert new node before the larger value
            position.link = new Node<T>(itemData, position.link);
        }
    }

    /**
     Removes the head node and returns true if the list contains at least
     one node. Returns false if the list is empty.
    */
    public boolean deleteHeadNode( )
    {
        if (head != null)
        {
            head = head.link;
            return true;
        }
        else
            return false;
    }

    /**
     Returns the number of nodes in the list.
    */
    public int size( )
    {
        int count = 0;
        Node<T> position = head;
        while (position != null)
        {
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean contains(T item)
    {
        return (find(item) != null);
    }

    /**
     Finds the first node containing the target item, and returns a
     reference to that node. If target is not in the list, null is returned.
    */
    private Node<T> find(T target)
    {
        Node<T> position = head;
        T itemAtPosition;
        while (position != null)
        {
            itemAtPosition = position.data;
            if (itemAtPosition.equals(target))
                return position;
            position = position.link;
        }
        return null; //target was not found
    }

    /**
     Finds the first node containing the target and returns a reference
      to the data in that node. If target is not in the list, null is returned.
    */
    public T findData(T target)
    {
        return find(target).data;
    }

    public void outputList( )
    {
        Node<T> position = head;
        while (position != null)
        {
            System.out.println(position.data);
            position = position.link;
        }
    }

    public boolean isEmpty( )
    {
        return (head == null);
    }

    public void clear( )
    {
        head = null;
    }

   /*
    For two lists to be equal they must contain the same data items in
    the same order. The equals method of T is used to compare data items.
   */
   public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            @SuppressWarnings("unchecked")
            LinkedList3<T> otherList = (LinkedList3<T>)otherObject;
            if (size( ) != otherList.size( ))
                return false;
            Node<T> position = head;
            Node<T> otherPosition = otherList.head;
            while (position != null)
            {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.link;
                otherPosition = otherPosition.link;
            }
            return true; //no mismatch was not found
        }
    }

}
