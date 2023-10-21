import java.util.ArrayList;
import java.util.Collections;

public class Session {
    private String sessionID;
    private ArrayList<Student> studentList;
    private ArrayList<Double> quizScores;
    private ArrayList<Double> examScores;

    public Session (String sessionID){
        this.sessionID = sessionID;
        this.studentList = new ArrayList<Student>();
        this.quizScores = new ArrayList<Double>();
        this.examScores = new ArrayList<Double>();
    }

    public String getSessionID(){
        return sessionID;
    }
    public void enrollStudent(FtStudent student){
        this.studentList.add(student);
        //System.out.println(student.getStudentID()+", "+student.getFullName()+", now enrolled as a full time student");
    }
    public void enrollStudent(PtStudent student){
        this.studentList.add(student);
        //System.out.println(student.getStudentID()+", "+student.getFullName()+", now enrolled as a part time student");
    }

    public void assignStudentQuizScore(Student st, double score){
        if(st instanceof PtStudent){
            ((PtStudent) st).takeQuizInSession(this.sessionID, score);
            this.quizScores.add(score);
        }
        if(st instanceof FtStudent){
            ((FtStudent) st).takeQuizInSession(this.sessionID, score);
            this.quizScores.add(score);
        }
    }

    public void assignStudentExamScore(Student st, double score){
        if(st instanceof FtStudent){
            ((FtStudent) st).takeExamInSession(this.sessionID, score);
            this.examScores.add(score);
        }
    }

    public double getQuizAverageScore(){
        double totalScores = 0.0;
        for(Student st:studentList){
            if(st instanceof PtStudent){
                totalScores += ((PtStudent) st).getQuizScores().get(this.sessionID);
            }
            if(st instanceof FtStudent){
                totalScores += ((FtStudent) st).getQuizScores().get(this.sessionID);
            }
        }
        return totalScores*1.0/studentList.size();
    }

    public String quizScoresAsc(){
        Collections.sort(quizScores);
        String quizScoresAsc = "Quiz scores in ascending order: \n";
        for(double score:quizScores){
            quizScoresAsc += score+"\n";
        }
        return quizScoresAsc;
    }
    public String getPtStudentsNames(){
        String allPtStudentNames = "All part time students in this session \n";
        for(Student st:studentList){
            if(st instanceof PtStudent){
                allPtStudentNames += st.getFullName()+"\n";
            }
        }
        return allPtStudentNames;
    }
    public String sessionSummaryExamScores(){
        String sessionSummary = "Exam scores (for full time students) in this session \n";
        for(Student st:studentList){
            if(st instanceof FtStudent){
                sessionSummary += st.getStudentID() + ", "+ st.getFullName() +": "+((FtStudent) st).getExamScores().get(sessionID) +"\n";
            }
        }
        return sessionSummary;
    }

}
