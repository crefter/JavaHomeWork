package GUI.QuizCard;

public class QuizCard {

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    private String question;
    private String answer;

    public QuizCard(String q, String a) {
        question = q;
        answer = a;
    }


}
