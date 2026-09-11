import java.util.Scanner;

public class Problem04_LibraryISBNNormalizerValidator {

    public static String normalizeISBN(String raw) {
        raw = raw.trim();

        if (raw.length() < 3) {
            return raw.toUpperCase();
        }

        String publisherCode = raw.substring(0, 3).toUpperCase();
        String remaining = raw.substring(3);

        return publisherCode + remaining;
    }

    public static String validateISBN(String isbn) {

        if (isbn.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(isbn.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < isbn.length(); i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = isbn.substring(0, 3);
        String year = isbn.substring(3, 7);
        String catalog = isbn.substring(7);

        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(publisherCode)
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN: ");
        String raw = sc.nextLine();

        String normalized = normalizeISBN(raw);

        System.out.println(validateISBN(normalized));

        sc.close();
    }
}