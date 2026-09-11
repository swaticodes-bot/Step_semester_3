import java.util.Scanner;
import java.util.Random;

public class Problem01_RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Rock/Paper/Scissors: ");
            String player = sc.next();
            String computer = moves[random.nextInt(3)];

            String result = playRound(player, computer);
            System.out.println("Computer: " + computer + " | " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println("\nWins: " + wins + " | Losses: " + losses +
                " | Draws: " + draws);
        System.out.println("Win %: " + (wins * 100.0 / 5));
    }
}