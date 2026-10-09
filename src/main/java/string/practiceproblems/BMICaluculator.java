
package string.practiceproblems;

import java.util.Scanner;

public class BMICaluculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    static void printWellnessReport(double[] heights,
                                    double[] weights) {
        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] /
                    (heights[i] * heights[i]);

            System.out.printf("%-10d %-12.2f %-12.2f %-10.2f %-15s%n",
                    i + 1, heights[i], weights[i],
                    bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter height in meters: ");
            heights[i] = sc.nextDouble();

            while (heights[i] <= 0) {
                System.out.print("Height must be positive. Enter again: ");
                heights[i] = sc.nextDouble();
            }

            System.out.print("Enter weight in kg: ");
            weights[i] = sc.nextDouble();

            while (weights[i] <= 0) {
                System.out.print("Weight must be positive. Enter again: ");
                weights[i] = sc.nextDouble();
            }
        }

        System.out.println("\nWELLNESS REPORT");
        printWellnessReport(heights, weights);

        sc.close();
    }
}