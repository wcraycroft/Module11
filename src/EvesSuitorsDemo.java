/* EvesSuitorsDemo.java
 * Author:  William Craycroft
 * Module:  11
 * Project: HW 11 - Project 1
 * Problem Statement: Use a circular linked list to determine which of Eve's suitor will be chosen.
 *
 * Algorithm / Plan:
 *      1. Prompt user for the number of suitors.
 *      2. Instantiate linked list
 *      3. Iterate through next two suitors in list, returning the third.
 *      4. Print the current list of suitors along with which suitor was last eliminated and the position of the iterator
 *      5. Repeat step 3 and 4 until only 1 suitor remains.
 *      6. Return the final suitor as the winner
 *      7. Loop through queue and use poll method to remove and print each item until the queue is empty (returns null)
 */

import java.util.Scanner;

public class EvesSuitorsDemo {

    public static void main(String[] args) {
        int suitors;
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            // Prompt user for number of suitors
            System.out.print("How many suitors are asking for Eve's hand (0 to quit): ");
            suitors = keyboard.nextInt();

            if (suitors < 1) {
                break;
            }

            // Create linked list of suitors
            CircularLinkedList suitorList = new CircularLinkedList();
            // Populate list
            for (int i = 1; i <= suitors; i++) {
                suitorList.append(i);
            }
            // Print the initial list of suitors
            System.out.println("\n" + suitorList + "Initial list of suitors; start counting from " + suitorList.getCurrentSuitor() + ".");

            // Loop through suitor removal until 1 suitor remains
            while (suitorList.size() > 1) {
                int removedSuitor = suitorList.removeNextSuitor();
                if (suitorList.size() == 1) {
                    System.out.println(suitorList + "Suitor " + removedSuitor + " eliminated; " + suitorList.getCurrentSuitor() + " is the lucky winner!\n");
                }
                else {
                    System.out.println(suitorList + "Suitor " + removedSuitor + " eliminated; continue counting from " + suitorList.getCurrentSuitor() + ".");
                }


            }

        } // end of user prompt

        System.out.println("Goodbye.");
    } // end of main
}
