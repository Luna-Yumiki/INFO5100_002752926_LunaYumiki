public class Student {
    private int studentID;
    private String fullName;
    public Student(int studentID, String fullName){
        setStudentID(studentID);
        setFullName(fullName);
    }
    public String getFullName(){
        return fullName;
    }
    public int getStudentID(){
        return studentID;
    }

    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

}
