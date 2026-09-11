import java.util.*;

public class Problem05_StopWordFilteredWordFrequencyReport {

    public static void generateReport(String paragraph) {

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace(".", "");
        paragraph = paragraph.replace(",", "");

        String[] words = paragraph.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter paragraph: ");
        String paragraph = sc.nextLine();

        generateReport(paragraph);

        sc.close();
    }
}