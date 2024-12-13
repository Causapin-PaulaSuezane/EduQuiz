
<h1 align="center">
  <br>
  <a><img src="https://github.com/Causapin-PaulaSuezane/EduQuiz/blob/main/EduQuiz%20logo.png" alt="EduQuiz"></a>
  <br>
  EduQuiz📝
  <br>
</h1>

<h4 align="center">An Interactive Console Quiz Application</h4>


<p align="center">
 Welcome to <strong>EduQuiz</strong>! 🎉 This is a simple, text-based  <strong>Java console application</strong> designed to enhance learning through interactive quizzes. Teachers can create quiz questions for their students, and students can take quizzes at any time, from anywhere, all within a command-line interface. 🤓💡
 </p>
 
<p align="center">
  <a href="#features-">Features</a> •
  <a href="#i-project-overview-">Overview</a> •
  <a href="#ii-oop-principles-">OOP Principles</a> •
  <a href="#iii-details-of-the-chosen-sdg-and-its-integration-">SDG Goal</a> •
  <a href="#iv-how-to-run-">How To Run</a> •
  <a href="#important-notes-">Impotant Notes</a> 
</p>

<br>
<p align="center">. . .
</p>

---

# Features ✨

<h1 align="center">
  <a><img src="https://github.com/Causapin-PaulaSuezane/practice-repo-main/blob/main/FEATURES.gif" alt="Features"></a>
</h1>
  
* 📝 Interactive Quizzes : Students can attempt multiple-choice quizzes in various subjects.
  
* 👨‍🏫 Teacher Functionality : Teachers can create, view, and edit quiz questions.
  
* 👨‍🎓 Student Profiles : Students can view their profiles and track their scores.
  
* 🌐 Subject Selection : Students can select a subject and take quizzes specific to it.
  
* 🔒 User Roles : Secure login system for teachers and students.
  
* 🧩 OOP Principles : Implements encapsulation, inheritance, abstraction, and polymorphism for better code organization and functionality.

---

# I. Project Overview 🚀

<h1 align="center">
  <a><img src="https://github.com/Causapin-PaulaSuezane/practice-repo-main/blob/main/FEATURES%20(1).gif" alt="Project Overview"></a>
</h1>
  

EduQuiz📝 is a fun, interactive console-based quiz application designed to promote engaging and accessible learning for students. It aims to support both teachers and learners in a seamless and effective way. Here's an overview of the key features:

- Multiple Subjects:
  - 📐 Math
  - 🧬 Science
  - 𓀘 History

- Teacher-Friendly:
  - Allows teachers to easily create quiz questions for students.

- Flexible and Accessible:
  - Students can take quizzes anytime 🕗 and anywhere 🗺.

- Aligned with SDG 4 (Quality Education) 💡:
  - Promotes quality education for all students, contributing to global educational goals.

EduQuiz is designed to make learning more accessible and engaging, ensuring that education remains a lifelong pursuit for everyone. 📚🫱🏼‍🫲🏻

---

# II. OOP Principles 🧑‍💻

<h1 align="center">
  <a><img src="https://github.com/Causapin-PaulaSuezane/practice-repo-main/blob/main/FEATURES%20(2).gif" alt="OOP Principles"></a>
</h1>

## 1. Encapsulation 🔐

Encapsulation is achieved through organizing data and behavior in the form of private fields and public methods (getters and setters) for controlled access and integrity of data. Following methods are used to get or modify the private data fields:

  - Used in the `User class`, `Student class`, and `Teacher class` with `private attributes` and `public getters and setter`.
    
  - Class `QuestionMulti` also uses `encapsulation` as it stores all data and behaviors related to a multiple-choice question. By using `private fields` and `public methods `, it ensures that `questions`, `options`, and `answers` are managed securely and accessed only through controlled mechanisms.
    
### **Private Attributes** 🔒
  - User details like `fullname`, `username`, `password`, `role` and `quiz data ` are declared as **private** in their respective classes, preventing unauthorized access or modification.
###### User.java
```java
    public abstract class User {
        private String username;
        private String password;
        private String fullname;
        private ArrayList<String> subjects;
```

<br>
<br>
    
  - `Question Multi` class' private attributes are `question`, `optionA`, `optionB`, `optionC`, `optionD`, `correctAnswer`, `createdBy`, and `subject`.
###### QuestionMulti.java
```java
    public class QuestionMulti {
        private String question;
        private String optionA;
        private String optionB;
        private String optionC;
        private String optionD;
        private String correctAnswer;
        private String createdBy;
        private String subject;
```

<br>
<br>
    
### **Public Getters and Setter** 🌎
  - **User-Related Getters** 👩🏻‍💻
    - `getUsername()` : Retrieves the user's username.
    - `getPassword()` : Retrieves the user's password.
    - `getFullname()` : Retrieves the user's full name.
    - `getRole()` : Retrieves the role chosen by the user (e.g., student or teacher).
    - `getSubjects()` : Retrieves the user's chosen subject.
###### User.java
```java
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullname() { return fullname; }
    public ArrayList<String> getSubjects() { return subjects; }
    public abstract String getRole();   
```

<br>
<br>

  - **Student-Specific Methods** 👩🏻‍🎓
    - `getScores()` : Retrieves the student's score for all subjects.
    - `setScore(int subjectIndex, int score)` : Updates the student's score for a specific subject.
###### Student.java
```java
    public ArrayList<Integer> getScores() { return scores; }
    public void setScore(int subjectIndex, int score) { scores.set(subjectIndex, score); }

```

<br>
<br>


  - **Quiz-Related Getters** ✏️
    - `getQuestion()` : Retrieves the stored quiz questions.
    - `getOptionA()`, `getOptionB()`, `getOptionC()`, `getOptionD()` : Retrieve the options for the multiple-choice quiz questions.
    - `getCorrectAnswer()` : Retrieves the correct answer for a quiz question.
    - `getCreatedBy()` : Retrieves the creator of a specific quiz question.
###### QuestionMulti.java
```java
    public String getQuestion() { return question; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getCreatedBy() { return createdBy; }
    public String getSubject() { return subject; }
```

<br>

---

## 2. **Inheritance** 🌳 
Inheritance is an object-oriented programming principle where a child class inherits attributes and methods from a parent class. This promotes code reuse and establishes a hierarchical relationship between classes. 

  - Used mainly in the `User class`, `Student class`, and `Teacher class` where `User` is the **parent class** and `Student` and `Teacher` are the child classes.

### **Parent Class (User)** 👵🏼
  - `User` : common attributes like `username`, `password`, `fullname`, `subjects` were encapsulated in the parent class. These attributes represent shared properties that are inherited by specific user types, such as `Student` or `Teacher`, ensuring a consistent structure while allowing for specialized behavior in the child classes.
###### User.java
```java
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
```

<br>
<br>

### **Child Classes (Student, Teacher)** 👶🏼
  - `Student` : attributes like `username`, `password`, `fullname`, and `subjects`  were inherited from the parent class `User`. Additionaly, an attribute like `score` was introduced uniquely to the student chile class and not inherited from the parent class.
###### Student.java
```java
    public class Student extends User { 

        private ArrayList<Integer> scores;  

        public Student(String username, String password, String fullname, ArrayList<String> subjects, int score) {
            super(username, password, fullname, subjects); 
            this.scores = new ArrayList<>(subjects.size()); 

            for (int i = 0; i < subjects.size(); i++) { 
                scores.add(0);
            }
        }
    }
```

<br>
<br>
    
  - `Teacher` : same as the student's classes that were inherited from the parent class `User`.
###### Teacher.java
```java
    public class Teacher extends User {

      public Teacher(String username, String password, String fullname, ArrayList<String> subjects) {
        super(username, password, fullname, subjects);
    }
```

---
    
## 3. **Polymorphism** 🔄
Polymorphism is an object-oriented programming principle that allows objects of different types to be treated as objects of a common super type. The two main types of polymorphism are :

  - Compile-time Polymorphism (Method Overloading)
  - Runtime Polymorphism (Method Overriding)

### **Method Overloading** ⚡
Methods like `addQuestion()` and `removeQuestion()` demonstrate method overloading. Each method name is used to edit the teacher-created questions with different parameter lists to handle different scenarios.
    
  - `addQuestion()` : supports adding pre-defined questions programmatically or interactively creating questions at runtime.
###### addQuestion() in the QuizUtils.java
```java
    public static void addQuestion(String subject, QuestionMulti question) {
        switch (subject.toLowerCase()) { 
            case "science":
                scienceQuestions.add(question);
                break;
            case "math":
                mathQuestions.add(question);
                break;
            case "history":
                historyQuestions.add(question);
                break;
            default:
                System.out.println("Invalid subject: " + subject); 
        }
    }
```

###### addQuestion() in the QuizEditor.java
```java
    public static void addQuestion(Teacher teacher, Scanner scanner) {
        String subject = QuizUtils.promptForSubject(teacher, scanner); 
        System.out.println("");

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) { 
            System.out.println("\nUnregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        // once subject is valid, proceed here
        String questionText = QuizUtils.getEmptyInput(scanner, "Enter question text: ");
        String optionA = QuizUtils.getEmptyInput(scanner, "Enter option A: ");
        String optionB = QuizUtils.getEmptyInput(scanner, "Enter option B: ");
        String optionC = QuizUtils.getEmptyInput(scanner, "Enter option C: ");
        String optionD = QuizUtils.getEmptyInput(scanner, "Enter option D: ");
    
        String correctAnswer;
        
        while (true) {
            System.out.print("Enter correct answer (a/b/c/d): ");
            correctAnswer = scanner.nextLine().toLowerCase().trim();

             if (correctAnswer.equals("a") || correctAnswer.equals("b") || correctAnswer.equals("c") || correctAnswer.equals("d")) {
                break;
            } else {
                System.out.println("\nInvalid input. Please enter only 'a', 'b', 'c', or 'd'.\n");
            }
        }

        QuestionMulti question = new QuestionMulti(questionText, optionA, optionB, optionC, optionD, correctAnswer, teacher.getFullname(), subject); 
        QuizUtils.addQuestion(subject, question); 
        System.out.println("\n\t**** Question added by " + teacher.getFullname() + " to subject " + subject + ". ****");
    }
```

<br>
<br>

   - `removeQuestion()` : The removeQuestion methods work in tandem to delete questions. The interactive method `(removeQuestion(Teacher teacher, Scanner scanner)` allows teachers to browse through and pick out questions to remove at runtime, thus being user-friendly. While the method `(removeQuestion(QuestionMulti question)` actually deletes the question picked from the system in the background.
###### removeQuestion() in the QuizUtils.java
```java
    public static void removeQuestion(QuestionMulti question) {
        switch (question.getSubject().toLowerCase())  {
            case "science":
                scienceQuestions.remove(question);
                break;
            case "math":
                mathQuestions.remove(question);
                break;
            case "history":
                historyQuestions.remove(question);
                break;
            default:
                System.out.println("Invalid subject"); 
        }
    }
```

###### removeQuestion() in the QuizEditor.java
```java
    public static void removeQuestion(Teacher teacher, Scanner scanner) {
        String subject = QuizUtils.promptForSubject(teacher, scanner); 

        if (!QuizUtils.isTeacherRegisteredForSubject(teacher, subject)) { 
            System.out.println("\nUnregistered subject. Please enter a subject you are registered for: " + teacher.getSubjects());
            System.out.println("Going back.....");
            return;
        }

        ArrayList<QuestionMulti> teacherQuestions = QuizUtils.getTeacherQuestions(teacher, subject); 
        
        System.out.print("\n\t---- Here are your Question/s ----\n ");

        QuizUtils.displayQuestions(teacherQuestions); 

        if (!teacherQuestions.isEmpty()) { 
            System.out.print("\n(type any key to go back)\n");
            System.out.print("Enter the number of the question to delete: ");

            try {
                int questionIndex = scanner.nextInt();
                scanner.nextLine();

                if (questionIndex > 0 && questionIndex <= teacherQuestions.size()) { 
                    QuizUtils.removeQuestion(teacherQuestions.get(questionIndex - 1));
                    System.out.println("\n\t**** Question deleted. ****"); 
                } else {
                    System.out.println("Invalid choice. Going back..."); 
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Going back..."); 
                scanner.nextLine();
            }
        }
    }
```


<br>
<br>

### **Method Overriding** 🎡
  - `register(ArrayList<User> users)` : method is overriden in both `Student` and `Teacher`. Depending on the role that the current user chooses, they use this method to add the current user in the `users arraylist`.
```java
    @Override
    public void register(ArrayList<User> users) { 
      users.add(this);
    }
```

<br>
<br>
    
  - `getRole()` : Method is overriden in both child classes. This returns a different role: `"Student"` for the student class and `"Teacher"` for the teacher class.
###### Student.java
```java
    @Override
    public String getRole() { return "Student"; }
```
###### Teacher.java
```java
    @Override
    public String getRole() { return "Teacher"; }
```

<br>
<br>
    
  - `viewProfile()` : Overriden in both child classes. The base method displays general user profile information, and both subclasses enhance the behavior by adding specific information related to the `Student` or `Teacher` role.
###### Student.java
```java
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

```
###### Teacher.java
```java
    @Override
    public void viewProfile() { 
        super.viewProfile();
    }
```

<br>
<br>
    
  - `displayRole()` : Both overriden in the child classes also. Displays the `role` depending by the chosen role of the current user.
###### Student.java
```java
    @Override
    public void displayRole() {
        System.out.println("\n**** Student Role: Can take quizzes and view results. ****");
    }
```

###### Teacher.java
```java
    @Override
    public void displayRole() { 
        System.out.println("\n**** Teacher Role: Manage own quizzes and view all questions. ****");
    }
```

---
    
## 4. **Abstraction** 🖼
Abstraction is the concept of hiding implementation details and exposing only the essential features of an object. This is achieved using abstract classes or interfaces, allowing subclasses to define specific behaviors while maintaining a clear, simplified interface.

  - `User Class` : An abstract class that defines the structure for `register()`, `getRole()`, `displayRole()`, and `viewProfile()` methods, leaving the implementation details to the child classes.
  - `Student/Teacher Classes` : These classes provide specific implementations of the abstract methods defined in the `User class`, defining how a student or teacher registers, what their role is, and the functions associated with their roles.
    
---

# III. Details of the Chosen SDG and Its Integration 🌍

<h1 align="center">
  <a><img src="https://github.com/Causapin-PaulaSuezane/practice-repo-main/blob/main/FEATURES%20(3).gif" alt="SDG Goals"></a>
</h1>  
 
The **EduQuiz** project supports **SDG 4: Quality Education** by providing an interactive venue for students to learn and take quizzes on a wide range of subjects. It continuously motivates learners to pursue self-assessment, which is a pillar in the development of education.

Here's how it integrates SDG 4📄✏️

- **Inclusive Education:** The application makes it accessible to all the students irrespective of their location so that they can take quizzes at any time and anywhere. This achieves quality education for everybody. 🌏
- **Personalized Learning:** Students can take quizzes on subjects they are registered for, enabling them to focus on areas they need to improve, thus supporting personalized learning paths. 📈

---

# IV. How To Run 🏃

<h1 align="center">
  <a><img src="https://github.com/Causapin-PaulaSuezane/practice-repo-main/blob/main/FEATURES%20(4).gif" alt="How to Run"></a>
</h1>

### What You'll Need 🛠️
- Visual Studio Code (VS Code)
- Java Development Kit (JDK)
- Java Extension Pack

### Steps to Run the Program 🖋
 1. Install Necessary Software
    - Download and install [VS Code](https://code.visualstudio.com/).
    - Install the latest JDK from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.org/).
    - Open VS Code and install the Java Extension Pack from the Extensions Marketplace.
      
2. Clone the Repository
    - Open a terminal in VS Code or use your system terminal to download the project files :
    ```bash
    git clone https://github.com/Causapin-PaulaSuezane/EduQuiz.git
    cd EduQuiz
    ```
    
3. Open the Project in VS Code
    - Launch VS Code and open the folder containing the project files :
    ```bash
    File  → Open Folder  → Select the EduQuiz directory
    ```
    
4. Compile the Program
    - Ensure that the VS Code recognizes the JDK.
    - Open the `Main.java` file, and press `Ctrl + Shift + B` (Windows/Linux) or `Cmd + Shift + B` (Mac) to build the program.
      
5. Run the Program
    - Open the terminal in VS Code:
    ```bash
      View → Terminal
    ```
    - Execute the program by running:
    ```bash
      java Main
    ```
6. Main Menu Navigation
    - Create your first account by signing up.
    - Select a role between as a `Student` or a `Teacher`.
    - After selecting a role, enter your `username`, `password` and `fullname`.
    - Then choose what subject/s to take.
    - After signing up, proceed to log in.
<br>

#### For Students 🎓

1. **Log in**: Enter your student credentials.
2. **Student Menu**:
  <br> Options include:
   - **Take a Quiz**: Choose a subject you are registered in and answer the questions. Your scores will be updated to your student profile.
   - **View Profile**: See your name and quiz performance.
   - **Log out**: Return to the main menu after completing your actions.

#### For Teachers 👩‍🏫

1. **Log in**: Enter your teacher credentials.
2. **Teacher Menu**:
  <br> Options include:
   - **Edit Quiz Question**: Add or delete your own teacher-created questions to a subject quiz.
   - **View Quiz**: View your own created questions and view all the questions in a selected registered subject.
   - **Log out**: Return to the main menu when you're finished.
     
---

# File Structures 📂

<h1 align="center">
  <a><img src="https://github.com/Causapin-PaulaSuezane/practice-repo-main/blob/main/FEATURES%20(5).gif" alt="File Structure"></a>
</h1>


## For EduQuiz (OOP) 🧩
```
EduQuiz/ 
├── Main.java 
├── Quiz/ 
│   ├── QuizSubjects/ 
│   │   ├── HistoryQuiz.java
│   │   ├── MathQuiz.java
│   │   └── ScienceQuiz.java
│   ├── QuestionMulti.java
│   ├── QuizEditor.java
│   ├── QuizUtils.java
│   ├── QuizViewer.java
│   └── TakeQuiz.java
├── Register/
│   └── RegisterFunction.java
├── Users/
│   ├── Menu/
│   │   ├── StudentMenu.java
│   │   └── TeacherMenu.java
│   ├── Student.java
│   ├── Teacher.java
│   └── User.java
```

## For EduQuiz w/ MySQL (DBMS) 🐬
```
DBMS Project/
└── EduQuizWithSQL/
    ├── Main.java
    ├── Database/
    │   ├── DatabaseConn.java
    │   └── QuestionDatabaseHandler.java
    ├── Quiz/
    │   ├── QuizSubjects/
    │   │   ├── HistoryQuiz.java
    │   │   ├── MathQuiz.java
    │   │   └── ScienceQuiz.java
    │   ├── QuestionMulti.java
    │   ├── QuizEditor.java
    │   ├── QuizUtils.java
    │   ├── QuizViewer.java
    │   └── TakeQuiz.java
    ├── Register/
    │   └── RegisterFunction.java
    ├── Users/
    │   ├── Menu/
    │   │   ├── StudentMenu.java
    │   │   └── TeacherMenu.java
    │   ├── Student.java
    │   ├── Teacher.java
    │   └── User.java
    ├── db/
    │   ├── init.sql
    │   └── schema.png
    └── lib/
        └── mysql-connector-j-9.1.0.jar

```

---

# Important Notes 📜

<h1 align="center">
  <a><img src="https://github.com/Causapin-PaulaSuezane/practice-repo-main/blob/main/FEATURES%20(6).gif" alt="Important Notes"></a>
</h1>
  
## For OOP 📌
🎬**Video Presentation** is 10:02 long🕦 <br>
🔗Link : [OOP Presentation Video](https://drive.google.com/file/d/1C6M1lvVm8K8vPzmlhlPA11QPynf4luhh/view?usp=drive_link)

🎬**Program Run** is 04:16 long🕦..
Program Run is for extra only... Its a video that shows how the EduQuiz runs. <br>
(video is in ×1.5 speed, audio is poor coz of laptop's microphone performance) <br>
🔗Link : [Program Run](https://drive.google.com/file/d/1Dx9LuFJWQ3ihw5oHW1shQXyJjc-rAWxn/view?usp=drive_link)
<br>

## For DBMS 📌
🎬**Video Presentation** is 14:13 long🕦 <br>
🔗Link : [DBMS Vid Presentation](https://drive.google.com/file/d/1YhBH6poHoxx6qcL9Y2mB7SJMKArzVz2D/view?usp=drive_link)
<br>

---

## Full File Link 📌
📂 **Folder Contents**
```
**EDUQUIZ - OOP and DBMS Presentation**

├── **DBMS Project - (Vid Presentation)**
│   └── DBMS_VideoPresentation [video]
│
├── **OOP Project - (Vid Presentation)**
│   ├── **OOP Presentation**
│   │   └── OOP Presentation [video]
│   │
│   ├── **PPT Used**
│   │   └── EduQuiz [ppt]
│   │
│   └── **Program Run**
│       └── Program Run [video]

```
🔗link : [Gdrive Link](https://drive.google.com/drive/folders/1LiGeD7d1nJwOVQLZwjt7FYNbHlTXSUeM?usp=drive_link)

<p align="center">
<br>
<br>
<br>
<br>.
<br>.
<br>.
<br>≽^•⩊•^≼
  
</p>
