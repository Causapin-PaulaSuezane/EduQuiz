package Users;

import java.util.ArrayList;

public abstract class User { //parent class
    private String username;
    private String password;
    private String fullname;
    private ArrayList<String> subjects;

    public User(String username, String password, String fullname, ArrayList<String> subjects) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.subjects = subjects;
    }

    //Getters
    public String getUsername() { //gets the username
        return username;
    }

    public String getPassword() { //gets the password
        return password;
    }

    public String getFullname() { // gets the fullname
        return fullname;
    }

    public ArrayList<String> getSubjects() { // for getting the subject
        return subjects;
    }

    // for polymorphism (overriding)
    public abstract void register(ArrayList<User> users); // will be overriden in the child class

    public abstract String getRole();   // will be overriden in the child class

    public void viewProfile() {         // will be overriden in the child class
        System.out.println("\n--- User Profile ---\n");
        System.out.println("Name: " + fullname);
        System.out.println("Subjects: " + subjects);
    }

    public abstract void displayRole();
}

// can be used for polymorphism (overriding), used for inheritance and also uses encapsulation