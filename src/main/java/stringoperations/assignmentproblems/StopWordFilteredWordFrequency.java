
package stringoperations.assignmentproblems;

import java.util.*;

public class StopWordFilteredWordFrequency {

    void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleaned.split("\\s+");

        Set<String> stopWords = new HashSet<>(
                Arrays.asList("the", "was", "and", "a",
                        "is", "of", "in"));

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            word = word.trim();

            if (!word.isEmpty() && !stopWords.contains(word)) {
                frequency.put(word,
                        frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort((a, b) ->
                b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StopWordFilteredWordFrequency obj =
                new StopWordFilteredWordFrequency();

        obj.printFilteredWordFrequency(
                "The mentor was great, the session was great and clear.");
    }
}