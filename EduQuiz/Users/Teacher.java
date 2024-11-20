package Users;

import java.util.ArrayList;

public class Teacher extends User { // child class of parent class User 

    public Teacher(String username, String password, String fullname, ArrayList<String> subjects) {
        super(username, password, fullname, subjects); // borrows the attributes from the parent class
    }

    @Override
    public void register(ArrayList<User> users) { // adds the user in the array list of users
        users.add(this);
    }

    @Override
    public String getRole() { // User is a teacher
        return "Teacher";
    }

    @Override
    public void displayRole() { // displays the role and its abilities
        System.out.println("\n**** Teacher Role: Manage own quizzes and view all questions. ****");
    }

    @Override
    public void viewProfile() { // displays the profile of the user
        super.viewProfile();
    }
}
