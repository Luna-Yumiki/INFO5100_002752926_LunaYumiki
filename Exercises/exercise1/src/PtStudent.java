import java.util.HashMap;
public class PtStudent extends Student{
    private HashMap<String, Double> quizScores;
    public HashMap<String, Double> getQuizScores(){
        return quizScores;
    }
    public PtStudent(int studentID, String fullName) {
        super(studentID, fullName);
        this.quizScores = new HashMap<String, Double>();
    }
    public void takeQuizInSession(String sessionID, double score){
        this.quizScores.put(sessionID, score);
        System.out.println(this.getStudentID()+", "+this.getFullName()+" (part time), gets: "+score+" for the quiz");
    }
    public String summaryQuizScores(){
        String quizSummary = "Quiz Scores Summary for "+this.getStudentID()+ ", "+this.getFullName()+" \n";
        for(String sessionID:quizScores.keySet()){
            quizSummary += sessionID + ": " +quizScores.get(sessionID) +" \n";
        }
        return quizSummary;
    }
}
