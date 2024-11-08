public class Users {

    String username;
    String password;
    String fullname;

    public Users(String username, String password, String fullname){
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        
    }
}

class Admin extends Users {
    public Admin() {
        super("admin", "admin123", "Admin User");
    
    }
}

class Teacher extends Users {
    String subject;

    public Teacher(String username, String password, String fullname, String subject){
        super(username, password, fullname);
        this.subject = subject;
    }
}

class Student extends Users {
    String subject;
    int score;

    public Student(String username, String password, String fullname, String subject){
        super(username, password, fullname);
        this.subject = subject;
        this.score = 0;
    }
}