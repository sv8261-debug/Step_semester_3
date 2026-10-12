
package basicprograms.practiceproblems;

import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        boolean isPrime = number >= 2;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println("Is the number " + number
                + " a Prime number? " + isPrime);

        sc.close();
    }
}