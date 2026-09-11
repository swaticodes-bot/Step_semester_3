import java.util.Random;
import java.util.Scanner;

public class Problem01_RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] choices = {"Rock", "Paper", "Scissors"};

        for (int round = 1; round <= 5; round++) {

            System.out.print("Enter Rock/Paper/Scissors: ");
            String player = sc.nextLine();

            int computerIndex = random.nextInt(3);
            String computer = choices[computerIndex];

            System.out.print("Computer: " + computer + " | ");

            if (player.equalsIgnoreCase(computer)) {
                System.out.println("Draw");
                draws++;
            }
            else if ((player.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
                    (player.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
                    (player.equalsIgnoreCase("Scissors") && computer.equals("Paper"))) {
                System.out.println("Player Wins");
                wins++;
            }
            else {
                System.out.println("Computer Wins");
                losses++;
            }
        }

        double winPercentage = (wins * 100.0) / 5;

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + winPercentage);

        sc.close();
    }
}