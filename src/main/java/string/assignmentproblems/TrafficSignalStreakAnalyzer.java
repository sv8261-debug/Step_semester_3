
package string.assignmentproblems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("No signal readings found");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longest = 1;
        int current = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                current++;
            } else {
                current = 1;
            }

            if (current > longest) {
                longest = current;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor +
                "' repeated " + longest + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log (R, Y, G): ");
        String signalLog = sc.nextLine().toUpperCase();

        findLongestStreak(signalLog);
        sc.close();
    }
}