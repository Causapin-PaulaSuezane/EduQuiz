package Users;

import java.util.ArrayList;

public class Student extends User { // child class of parent class User

    private ArrayList<Integer> scores;  // an array list to store the score of student after the quiz

    public Student(String username, String password, String fullname, ArrayList<String> subjects, int score) {
        super(username, password, fullname, subjects); // borrowed attributes frm the parent class
        
        this.scores = new ArrayList<>(subjects.size()); // creates an array list called "scores" that matches the size of the number or subjects taken

        for (int i = 0; i < subjects.size(); i++) { // initial score for taken subject/s is 0.
            scores.add(0);
        }
    }

    public ArrayList<Integer> getScores() { // getter to get score/s. Used for view profile later.
        return scores;
    }

    public void setScore(int subjectIndex, int score) { // setter for score/s. Updates the score for a specific subject at a given index in the scores list
        scores.set(subjectIndex, score);
    }

    @Override
    public void register(ArrayList<User> users) { // adds the registered student to the array list of users
        users.add(this);
    }

    @Override
    public String getRole() { // Roles the user as Student
        return "Student";
    }

    @Override
    public void displayRole() { // Displays the role and its ability
        System.out.println("\n**** Student Role: Can take quizzes and view results. ****");
    }

    @Override
    public void viewProfile() { // view profile method from the parents class
        super.viewProfile();
        
        // Display the scores for each subject the student has taken
        for (int i = 0; i < getSubjects().size(); i++) {
            String subject = getSubjects().get(i); // fetches the subject at index i.
            int score = scores.get(i);  // Gets the score for the subject at the same index
            System.out.println(subject + " Score: " + score);
        }
    }
}
