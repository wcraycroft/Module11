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
