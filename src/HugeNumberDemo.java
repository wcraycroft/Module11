/* HugeNumberDemo.java
 * Author:  William Craycroft
 * Module:  11
 * Project: HW 11 - Project 2
 * Problem Statement: Demo the functionality of the Huge Number linked list class
 *
 * Algorithm / Plan:
 *      1. Instantiate 3 Huge Numbers
 *      2. Assign 12 random digits to each huge number.
 *      3. Print huge numbers.
 *      4. Test reset method, print result
 *      5. User iterator to print all digits from one of the huge numbers.
 */

import java.util.Random;

public class HugeNumberDemo {

    public static void main (String[] args)
    {
        // Declare 3 HugeNumbers
        HugeNumber hugeNumber1 = new HugeNumber();
        HugeNumber hugeNumber2 = new HugeNumber();
        HugeNumber hugeNumber3 = new HugeNumber();

        // Assign between 12-16 random digits to each HugeNumber
        for (int i = 0; i < 12; i ++)
        {
            hugeNumber1.addDigit(getRandomInt(10));
            hugeNumber2.addDigit(getRandomInt(10));
            hugeNumber3.addDigit(getRandomInt(10));
        }

        // Print 3 numbers
        System.out.println("HugeNumber1 = " + hugeNumber1);
        System.out.println("HugeNumber2 = " + hugeNumber2);
        System.out.println("HugeNumber3 = " + hugeNumber3);

        // Clear HugeNumber2
        hugeNumber2.reset();
        System.out.println("\nHugeNumber2 after reset = " + hugeNumber2);

        // Iterate through first 5 digits of HugeNumber1
        HugeNumber.Iterator iterator = hugeNumber1.iterator();
        System.out.print("\nHugeNumber1 digits using iterator = ");
        for (int i = 0; i < 12; i++)
        {
            System.out.print(iterator.next());
        }

    } // end of main

    // Returns a random integer between 0 and upper (exclusive)
    private static int getRandomInt(int upper)
    {
        Random random = new Random();
        return random.nextInt(upper);
    }
}
