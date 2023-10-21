import java.util.Random;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        //get random names from https://www.randomlists.com/random-names?qty=20
        String[] random_names = {
                "Matthew Simpson",
                "Davis Steele",
                "Kaitlynn Escobar",
                "Danny Silva",
                "Litzy Cherry",
                "Luke Yoder",
                "Jesse Torres",
                "Arielle Archer",
                "Liliana Estes",
                "Giovanny Gibson",
                "Ralph Villa",
                "Rowan Glenn",
                "Dwayne Pacheco",
                "Alicia Vaughan",
                "Davis Hudson",
                "Alejandro Dalton",
                "Darion Hurst",
                "Shaun Lozano",
                "Danny Ramos",
                "Serenity Chen"
        };

        Student[] class_students = new Student[random_names.length];

        //random to decide student type
        for(int i=0;i<random_names.length;i++){

            if(Math.random() > 0.5){
                class_students[i] = new FtStudent(10000+1+i, random_names[i]);
            }
            else{
                class_students[i] = new PtStudent(10000+1+i, random_names[i]);
            }

        }

        Session class_session = new Session("Session 1 - 2023-10-16");
        for(Student st:class_students){
            if(st instanceof FtStudent){
                class_session.enrollStudent((FtStudent) st);
            }
            else {
                class_session.enrollStudent((PtStudent) st);
            }
        }

        Random rand = new Random();
        DecimalFormat f = new DecimalFormat("##.00");

        System.out.println("========================================================");
        System.out.println("Quiz scores (both full time and part time students) for "+class_session.getSessionID());

        for(Student st:class_students){
            class_session.assignStudentQuizScore(st, Double.parseDouble(f.format(rand.nextDouble(0.0, 10.0))));
        }

        System.out.println("========================================================");
        System.out.println("Exam scores (only full time students) for "+class_session.getSessionID());

        for(Student st:class_students){
            if(st instanceof FtStudent){
                class_session.assignStudentExamScore(st, Double.parseDouble(f.format(rand.nextDouble(0.0, 100.0))));
            }
        }

        System.out.println("========================================================");
        System.out.println("Quiz average score (full is 10) is:"+Double.parseDouble(f.format(class_session.getQuizAverageScore())));

        System.out.println("========================================================");
        System.out.print(class_session.quizScoresAsc());

        System.out.println("========================================================");
        System.out.print(class_session.getPtStudentsNames());

        System.out.println("========================================================");
        System.out.print(class_session.sessionSummaryExamScores());

    }
}