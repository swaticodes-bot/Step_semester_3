import java.time.LocalDate;
import java.util.Scanner;

interface LibraryItem {
    int getBorrowingDays();
}

class Book implements LibraryItem {
    public int getBorrowingDays() {
        return 14;
    }
}

class DVD implements LibraryItem {
    public int getBorrowingDays() {
        return 7;
    }
}

class Magazine implements LibraryItem {
    public int getBorrowingDays() {
        return 3;
    }
}

public class A2_LibraryDueDate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1].replace("\"", "");

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book();
                    break;

                case "DVD":
                    item = new DVD();
                    break;

                case "MAGAZINE":
                    item = new Magazine();
                    break;

                default:
                    continue;
            }

            LocalDate dueDate =
                    currentDate.plusDays(item.getBorrowingDays());

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}