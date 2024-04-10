package App;

public class Question {
    //Question attributes
    private int questionNumber;
    private String correctAnswer;
    private String question;
    private String questionID;
    private String quizID;
    static private int AdderID = 0; //for setting ID number

    //constructor
    public Question(String correctAnswer, String question, String quizID){
        this.correctAnswer = correctAnswer;
        this.question = question;
        this.quizID = quizID;
    }

    //setting ID number
    //Question ID is unique for each question
    public void setNumberID(int questionNumber){
        Question.AdderID +=1;
        this.questionNumber = questionNumber;
        this.questionID = this.quizID + "q" + Question.AdderID;
    }

    //setters
    public void setQuestionNumber(int questionNumber){
        this.questionNumber = questionNumber;
    }
    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer = correctAnswer;
    }
    public void setQuestion(String question){
        this.question =question;
    }

    //getters
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
    public String getQuestion(){
        return this.question;
    }
    public int getQuestionNumber(){
        return this.questionNumber;
    }
    public String getQuestionID(){
        return this.questionID;
    }
    public String getQuizID(){
        return this.quizID;
    }
}
