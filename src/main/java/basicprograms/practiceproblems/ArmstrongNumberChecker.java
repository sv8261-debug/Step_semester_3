
package basicprograms.practiceproblems;

import java.util.Scanner;

public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int origNumber = number;
        int temp = number;
        int digits = String.valueOf(number).length();
        int sum = 0;

        if (number < 0) {
            digits = 0;
        }

        while (temp > 0) {
            int digit = temp % 10;
            int power = 1;

            for (int i = 0; i < digits; i++) {
                power *= digit;
            }

            sum += power;
            temp = temp / 10;
        }

        boolean isArmstrong = origNumber >= 0 && sum == origNumber;

        System.out.println("Is the number " + origNumber
                + " an Armstrong number? " + isArmstrong);

        sc.close();
    }
}
