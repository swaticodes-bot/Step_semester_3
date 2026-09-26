public class P2_Scorecard {

    private final boolean[] answers;
    private int answerCount;

    public P2_Scorecard(int totalQuestions) {
        answers = new boolean[totalQuestions];
        answerCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (answerCount < answers.length) {
            answers[answerCount] = isCorrect;
            answerCount++;
        } else {
            System.out.println("Answer recording rejected.");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (answers[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        P2_Scorecard scorecard = new P2_Scorecard(4);

        scorecard.recordAnswer(true);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);

        System.out.println("Final Score: " + scorecard.getScore());
    }
}