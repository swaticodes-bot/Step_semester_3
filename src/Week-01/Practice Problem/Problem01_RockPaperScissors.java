import java.util.Scanner;
import java.util.Random;

public class Problem01_RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] moves = {"Rock", "Paper", "Scissors"};

        for (int round = 1; round <= 5; round++) {

            System.out.println("Round " + round);
            System.out.print("Enter Rock, Paper or Scissors: ");
            String player = sc.next();

            int index = random.nextInt(3);
            String computer = moves[index];

            System.out.println("Computer chose: " + computer);

            if (player.equalsIgnoreCase(computer)) {
                System.out.println("Draw");
                draws++;
            }
            else if (
                    (player.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
                            (player.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
                            (player.equalsIgnoreCase("Scissors") && computer.equals("Paper"))
            ) {
                System.out.println("You Win");
                wins++;
            }
            else {
                System.out.println("You Lose");
                losses++;
            }

            System.out.println();
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        sc.close();
    }
}