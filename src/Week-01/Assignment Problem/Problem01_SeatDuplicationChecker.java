import java.util.Scanner;

public class Problem01_SeatDuplicationChecker {

    public static void checkDuplicates(int[] seatNumbers) {

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int n = sc.nextInt();

        int[] seatNumbers = new int[n];

        System.out.println("Enter seat numbers:");
        for (int i = 0; i < n; i++) {
            seatNumbers[i] = sc.nextInt();
        }

        checkDuplicates(seatNumbers);

        sc.close();
    }
}