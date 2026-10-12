
package basicprograms.practiceproblems;

import java.util.Scanner;

public class PalindromeNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();
        int origNumber = number;
        int reversedNumber = 0;

        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        System.out.println("Is the number " + origNumber
                + " a Palindrome? "
                + (origNumber >= 0 && reversedNumber == origNumber));

        sc.close();
    }
}