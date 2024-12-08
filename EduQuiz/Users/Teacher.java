package Users;

import java.util.ArrayList;

public class Teacher extends User {

    public Teacher(String username, String password, String fullname, ArrayList<String> subjects) {
        super(username, password, fullname, subjects); 
    }

    @Override
    public void register(ArrayList<User> users) { 
        users.add(this);
    }

    @Override
    public String getRole() { 
        return "Teacher";
    }

    @Override
    public void displayRole() { 
        System.out.println("\n**** Teacher Role: Manage own quizzes and view all questions. ****");
    }

    @Override
    public void viewProfile() { 
        super.viewProfile();
    }
}
