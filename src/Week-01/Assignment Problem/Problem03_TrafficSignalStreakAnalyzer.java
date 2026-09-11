import java.util.Scanner;

public class Problem03_TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {

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

        System.out.println("Color: " + longestColor);
        System.out.println("Streak Length: " + longest);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal readings: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}