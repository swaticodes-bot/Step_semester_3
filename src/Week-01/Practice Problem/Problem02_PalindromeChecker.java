import java.util.Scanner;

public class Problem02_PalindromeChecker {

    // Iterative approach
    public static boolean iterativeCheck(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // Recursive approach
    public static boolean recursiveCheck(String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return recursiveCheck(text, start + 1, end - 1);
    }

    // Character-array reversal approach
    public static boolean arrayCheck(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " + iterativeCheck(text));
        System.out.println("Recursive: " +
                recursiveCheck(text, 0, text.length() - 1));
        System.out.println("Character Array: " + arrayCheck(text));

        sc.close();
    }
}