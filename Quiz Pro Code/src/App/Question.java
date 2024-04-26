package App;

import DatabaseConnection.ConnectionProvider;
import java.sql.*;

public class Question {
    //Question attributes
    private int questionNumber;
    private String correctAnswer;
    private String question;
    private String questionID;
    private String quizID;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    static private int AdderID; //for setting ID number

    //constructor
    public Question(String correctAnswer, String question, String quizID, String option1, String option2, String option3, String option4){
        this.correctAnswer = correctAnswer;
        this.question = question;
        this.quizID = quizID;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
    
    private void setAdderID(){
        int quiz_id_num = this.quizID.length() + 2;
       try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM questionID WHERE quizID = ? ORDER BY CAST(SUBSTRING(id, ?) AS SIGNED) DESC LIMIT 1";
             
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, this.quizID);
            pst.setInt(2, quiz_id_num);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String maximum = rs.getString(1);
                    System.out.println("maccc" + maximum);
                    
                    if(maximum != null){
                        char[] arr = maximum.toCharArray();
                        String temp = "";                    
                        int q_index = 0;
                        
                        //find where the q
                        for(int i=0; i<arr.length; i++){
                            if(arr[i] == 'q'){
                                q_index = i+1;
                                break;
                            }
                        }
                        for(int i= q_index; i<arr.length; i++){
                            temp += arr[i];
                        }

                        Question.AdderID = Integer.parseInt(temp);
                    }else{
                        Question.AdderID = 0;
                    }
                } 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error:" + e.getMessage());
        }      
        
    }

    //setting ID number
    //Question ID is unique for each question
    public void setNumberID(int questionNumber){
        setAdderID();
        Question.AdderID +=1;
        this.questionNumber = questionNumber;
        this.questionID = this.quizID + "q" + Question.AdderID;
        
        try{
            Connection con = ConnectionProvider.getCon();
            String sql = "insert into questionID values(?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, this.questionID);
            pstmt.setString(2, this.quizID);
            pstmt.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
    public void setQuestionID(String id){
        this.questionID = id;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }   
    public void setOption2(String option2) {
        this.option2 = option2;
    }    
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
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
    public String getOption1() {
        return this.option1;
    }
    public String getOption2() {
        return this.option2;
    }
    public String getOption3() {
        return this.option3;
    }
    public String getOption4() {
        return this.option4;
    }
    public String getQuizID(){
        return this.quizID;
    }
}
