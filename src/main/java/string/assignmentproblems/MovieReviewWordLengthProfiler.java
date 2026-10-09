
package string.assignmentproblems;

import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {
        String[] words = review.trim().isEmpty()
                ? new String[0]
                : review.trim().split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");

            int length = cleanWord.length();

            if (length == 0) {
                continue;
            } else if (length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords +
                " | Medium: " + mediumWords +
                " | Long: " + longWords);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);
        sc.close();
    }
}