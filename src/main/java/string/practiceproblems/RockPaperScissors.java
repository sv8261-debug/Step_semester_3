
package string.practiceproblems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) +
                    " - Enter Rock, Paper, or Scissors: ");
            String player = sc.nextLine().trim();

            while (!player.equalsIgnoreCase("Rock") &&
                    !player.equalsIgnoreCase("Paper") &&
                    !player.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid move. Try again: ");
                player = sc.nextLine().trim();
            }

            player = player.substring(0, 1).toUpperCase()
                    + player.substring(1).toLowerCase();

            String computer = moves[random.nextInt(3)];
            String result = playRound(player, computer);

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            System.out.println(result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println("\nRound | Player Move | Computer Move | Result");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "     | " +
                    playerMoves[i] + "       | " +
                    computerMoves[i] + "        | " + results[i]);
        }

        double percentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", percentage);

        sc.close();
    }
}