package Users;

import java.util.ArrayList;

public class Student extends User { 

    private ArrayList<Integer> scores;  

    public Student(String username, String password, String fullname, ArrayList<String> subjects, int score) {
        super(username, password, fullname, subjects); 
        this.scores = new ArrayList<>(subjects.size()); 

        for (int i = 0; i < subjects.size(); i++) { 
            scores.add(0);
        }
    }

    public ArrayList<Integer> getScores() { 
        return scores;
    }

    public void setScore(int subjectIndex, int score) { 
        scores.set(subjectIndex, score);
    }

    @Override
    public void register(ArrayList<User> users) { 
        users.add(this);
    }

    @Override
    public String getRole() { 
        return "Student";
    }

    @Override
    public void displayRole() {
        System.out.println("\n**** Student Role: Can take quizzes and view results. ****");
    }

    @Override
    public void viewProfile() {
        super.viewProfile();
        
        // Display the scores for each subject the student has taken
        for (int i = 0; i < getSubjects().size(); i++) {
            String subject = getSubjects().get(i); 
            int score = scores.get(i); 
            System.out.println(subject + " Score: " + score);
        }
    }
}
