
package constructors.assignmentproblems;

import java.util.Arrays;

class Player implements Comparable<Player> {
    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Rule 1: Established players
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Newer players must be fit
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public boolean isInjured() {
        return injured;
    }

    public String getName() {
        return name;
    }

    // Rank players by batting average, highest first
    @Override
    public int compareTo(Player other) {
        return Double.compare(
                other.battingAverage, this.battingAverage
        );
    }
}

public class FantasyLeagueAutoDraftRankingEngine {

    static String draftAndRank(Player[] players) {
        Player[] draftable = Arrays.stream(players)
                .filter(p -> Player.isDraftable(p.getMatchesPlayed())
                        || Player.isDraftable(
                        p.getMatchesPlayed(), p.isInjured()))
                .toArray(Player[]::new);

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }

            result.append(i + 1)
                    .append(". ")
                    .append(draftable[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}