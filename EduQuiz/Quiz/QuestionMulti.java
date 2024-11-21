package Quiz;

public class QuestionMulti {
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
    private String createdBy;
    private String subject;

    public QuestionMulti(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer, String createdBy, String subject){
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.createdBy = createdBy;
        this.subject = subject;
    }

    // Getters
    public String getQuestion() { return question; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getCreatedBy() { return createdBy; }
    public String getSubject() { return subject; }

}
