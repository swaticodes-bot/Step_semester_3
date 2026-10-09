import java.util.Scanner;

public class A4_QuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.nextLine();
            String studentAnswer = sc.nextLine();
            String correctAnswer = sc.nextLine();
            double points = Double.parseDouble(sc.nextLine());

            double score = 0;

            if (type.equals("MCQ") || type.equals("TF")) {

                if (studentAnswer.equals(correctAnswer)) {
                    score = points;
                }

            } else if (type.equals("ESSAY")) {

                String[] keywords = correctAnswer.split(",");
                int matched = 0;

                for (String keyword : keywords) {
                    if (studentAnswer.toLowerCase()
                            .contains(keyword.trim().toLowerCase())) {
                        matched++;
                    }
                }

                if (matched >= 2) {
                    score = points * 0.75;
                } else if (matched == 1) {
                    score = points * 0.50;
                }
            }

            System.out.printf("%s: %.2f%n", type, score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}