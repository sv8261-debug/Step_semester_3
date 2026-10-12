
package constructors.practiceproblems;

import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Eligibility based on CGPA alone
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Eligibility based on CGPA and coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    public String getName() {
        return name;
    }

    // Composite score
    double compositeScore() {
        return cgpa * 10 + codingScore;
    }

    // Sort in descending order of composite score
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(
                other.compositeScore(),
                this.compositeScore()
        );
    }

    @Override
    public String toString() {
        return name + " (" + compositeScore() + ")";
    }
}

public class PlacementShortlistingEngine {

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = Arrays.stream(candidates)
                .filter(c -> Candidate.isEligible(c.getCgpa())
                        || Candidate.isEligible(
                        c.getCgpa(), c.getCodingScore()))
                .toArray(Candidate[]::new);

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1)
                    .append(". ")
                    .append(shortlisted[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}