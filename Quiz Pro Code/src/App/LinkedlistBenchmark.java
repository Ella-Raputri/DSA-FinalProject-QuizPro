package App;


public class LinkedlistBenchmark {
    //linked list for the Questions
    Linkedlist quiz = new Linkedlist();

    public void addQuestion(String question, String correctAnswer, String quizid, String opt1, String opt2, String opt3, String opt4){   
        //create a new Question object based on the given question and answer   
        Question q1 = new Question(correctAnswer, question, quizid, opt1, opt2, opt3, opt4);
        //add the Question object to the linked list
        quiz.addNode(q1);

        //set the ID number of the Question
        int tracker = 1;
        q1.setNumberID(tracker);
        //reset all the question number
        quiz.resetNumber();
        tracker++;
    }
    
    public void addQuestionUpdate(String question, String correctAnswer, String quizid, String opt1, String opt2, String opt3, String opt4){ 
        
        //create a new Question object based on the given question and answer   
        Question q1 = new Question(correctAnswer, question, quizid, opt1, opt2, opt3, opt4);
        //add the Question object to the linked list
        quiz.addNode(q1);

        //set the ID number of the Question
        int tracker = 1;
        //reset all the question number
        quiz.resetNumber();
        tracker++;
        
    }


    public void deleteQuestion(String id){
        //if linked list is empty, return
        if(quiz.isEmpty()){
            return;
        }
        else{
            //get the node that want to be deleted
            Linkedlist.Node current = quiz.getNode(id);

            //if there exists such a node
            if(current!= null){
                //delete that node and reset the question number
                quiz.deleteNode(current);
                quiz.resetNumber();
                return;
            }
            
        }
    }


    public void editQuestion(String id, String newQuestion, String newAnswer, String newopt1, String newopt2, String newopt3, String newopt4){
        //if linked list is empty, return
        if(quiz.isEmpty()){
            return;
        }
        else{
            //get the want to be edited node
            Linkedlist.Node current = quiz.getNode(id);
            //if there exists such a node
            if (current != null){
                //set the question based on the new question
                current.data.setQuestion(newQuestion);

                //set the answer based on the new answer
                current.data.setCorrectAnswer(newAnswer);
                
                //set the options
                current.data.setOption1(newopt1);
                current.data.setOption2(newopt2);
                current.data.setOption3(newopt3);
                current.data.setOption4(newopt4);
                
                return;
            }

        }
    }


    public void changeOrder(String id, int newNumber){
        //if linked list is empty, return
        if(quiz.isEmpty()){
            return;
        }
        //if there is only one node, return
        else if(quiz.head.equals(quiz.tail)){
            return;
        }
        else{
            //get the node that its order want to be changed 
            Linkedlist.Node current = quiz.getNode(id);
            //if there exists such a node
            if(current != null){
                //get the node's current number
                int currentNumber = current.data.getQuestionNumber();

                //if the node's number is the same as the new number, return
                if(currentNumber == newNumber){
                    return;
                }

                //if the new number is valid
                else if(newNumber <= Linkedlist.nodeAmount && newNumber > 0){
                    //change the node order and reset all of the question number
                    quiz.changeNodeOrder(newNumber, current, currentNumber);
                    quiz.resetNumber();
                }
                //if new number is not valid, return
                else if(newNumber > Linkedlist.nodeAmount || newNumber < 0){
                    return;
            }

            return;
        }

        }
    }


    public void printQuestions(){
        //if linked list is empty, return
        if(quiz.isEmpty()){
            return;
        }
        else{
            //set the current node to be the head
            Linkedlist.Node current = quiz.head;
            System.out.println("\nYour current quiz: ");

            //print all of the nodes information
            while(current!=null){
                System.out.println("Question " + current.data.getQuestionNumber());
                System.out.println("Question ID: "+ current.data.getQuestionID());
                System.out.println("Question: "+ current.data.getQuestion());
                System.out.println("Answer: "+ current.data.getCorrectAnswer());
                System.out.println("Option1: "+current.data.getOption1());
                System.out.println("Option2: "+current.data.getOption2());
                System.out.println("Option3: "+current.data.getOption3());
                System.out.println("Option4: "+current.data.getOption4());
                System.out.println();
            
                current = current.next;//proceed to the next node
            }
            
        }
    }


    public Linkedlist questionSearch(String str){
        Linkedlist res = new Linkedlist();
        //if linked list is empty, return
        if(quiz.isEmpty()){
            return null;
        }
        else{
            //to track whether exists a search result
            boolean track = false;
            //start the search from the head node
            Linkedlist.Node current = quiz.head;

            while(current!=null){
                //get the current node question and answer
                String question = current.data.getQuestion();
                String answer = current.data.getCorrectAnswer();
                String quizid = current.data.getQuizID();
                String opt1 = current.data.getOption1();
                String opt2 = current.data.getOption2();
                String opt3 = current.data.getOption3();
                String opt4 = current.data.getOption4();
                String questionID = current.data.getQuestionID();
                int question_number = current.data.getQuestionNumber();

                //if the question or answer contains the searched string
                if(containsIgnoreCase(question, str) || containsIgnoreCase(answer,str)){
                    Question data = new Question(answer, question, quizid, opt1, opt2, opt3, opt4);
                    //add the node to the linked list result
                    res.addNode(data);
                    
                    //set the number and id with the original one
                    res.tail.data.setQuestionID(questionID);
                    res.tail.data.setQuestionNumber(question_number);
                            
                    track = true; //set the track to true
                }
                //proceed to the next node
                current = current.next;
            }
            //if track is true, then return the result
            if(track){
                return res;
            }
            //if track is false (no result), then print the error message
            else{
                return null;
            }
        }
    }
    
    public boolean containsIgnoreCase(String src, String what) {
        final int length = what.length();
        if (length == 0)
            return true; // Empty string is contained

        final char firstLo = Character.toLowerCase(what.charAt(0));
        final char firstUp = Character.toUpperCase(what.charAt(0));

        for (int i = src.length() - length; i >= 0; i--) {
            // Quick check before calling the more expensive regionMatches() method:
            final char ch = src.charAt(i);
            if (ch != firstLo && ch != firstUp)
                continue;

            if (src.regionMatches(true, i, what, 0, length))
                return true;
        }

        return false;
    }
    
}
