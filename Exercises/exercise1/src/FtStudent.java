import java.util.HashMap;
public class FtStudent extends Student{
    private HashMap<String, Double> quizScores;
    private HashMap<String, Double> examScores;

    public HashMap<String, Double> getQuizScores(){
        return quizScores;
    }
    public HashMap<String, Double> getExamScores(){
        return examScores;
    }
    public FtStudent(int studentID, String fullName) {
        super(studentID, fullName);
        this.quizScores = new HashMap<String, Double>();
        this.examScores = new HashMap<String, Double>();
    }
    public void takeQuizInSession(String sessionID, double score){
        this.quizScores.put(sessionID, score);
        System.out.println(this.getStudentID()+", "+this.getFullName()+" (full time), gets: "+score+" for the quiz");
    }
    public void takeExamInSession(String sessionID, double score){
        this.examScores.put(sessionID, score);
        System.out.println(this.getStudentID()+", "+this.getFullName()+" (full time), gets: "+score+" for the exam");
    }
    public String summaryQuizScores(){
        String quizSummary = "Quiz Scores Summary for "+this.getStudentID()+ ", "+this.getFullName()+" \n";
        for(String sessionID:quizScores.keySet()){
            quizSummary += sessionID + ": " +quizScores.get(sessionID) +" \n";
        }
        return quizSummary;
    }
    public String summaryExamScores(){
        String examSummary = "Quiz Scores Summary for "+this.getStudentID()+ ", "+this.getFullName()+" \n";
        for(String sessionID:examScores.keySet()){
            examSummary += sessionID + ": " +examScores.get(sessionID) +" \n";
        }
        return examSummary;
    }
}
