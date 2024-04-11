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
    static private int AdderID; //for setting ID number

    //constructor
    public Question(String correctAnswer, String question, String quizID){
        this.correctAnswer = correctAnswer;
        this.question = question;
        this.quizID = quizID;
    }
    
    private void setAdderID(){
       try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT max(id) AS maxid FROM questionID WHERE quizID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, this.quizID);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String maximum = rs.getString("maxid");
                    
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
