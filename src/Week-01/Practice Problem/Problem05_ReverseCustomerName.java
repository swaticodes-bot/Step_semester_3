import java.util.Scanner;

public class Problem05_ReverseCustomerName {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        String reversed = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reversed = reversed + name.charAt(i);
        }

        System.out.println("Reversed Customer Name: " + reversed);

        sc.close();
    }
}