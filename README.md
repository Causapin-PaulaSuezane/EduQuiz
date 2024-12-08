
<h1 align="center">
  <br>
  <a><img src="
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
  <a href="#iv-how-to-run">How To Run</a> 
</p>

<br>
<p align="center">. . .
</p>

---

# Features ✨

* 📝 Interactive Quizzes : Students can attempt multiple-choice quizzes in various subjects.
  
* 👨‍🏫 Teacher Functionality : Teachers can create, view, and edit quiz questions.
  
* 👨‍🎓 Student Profiles : Students can view their profiles and track their scores.
  
* 🌐 Subject Selection : Students can select a subject and take quizzes specific to it.
  
* 🔒 User Roles : Secure login system for teachers and students.
  
* 🧩 OOP Principles : Implements encapsulation, inheritance, abstraction, and polymorphism for better code organization and functionality.

---

# I. Project Overview 🚀

EduQuiz📝 is a fun, interactive console-based quiz application designed with a motive towards engaging and accessible learning for students. The application includes multiple subjects, such as `Math📐`, `Science🧬`, and `History𓀘`, which allows teachers to create quiz questions that can be taken by students anytime🕗 and anywhere🗺. With an accessible platform, EduQuiz aligns with Sustainable Development Goal 4 (Quality Education)💡 by promoting quality education and other focused education for all.📚🫱🏼‍🫲🏻

---

# II. OOP Principles 🧑‍💻

### 1. Encapsulation 🔐

Encapsulation is achieved through organizing data and behavior in the form of private fields and public methods (getters and setters) for controlled access and integrity of data. Following methods are used to get or modify the private data fields:

  - Used in the `User class`, `Student class`, and `Teacher class` with `priavte attributes` and `public getters and setter`.
    
  - Class `QuestionMulti` also uses `encapsulation` as it stores all data and behaviors related to a multiple-choice question. By using `private fields` and `public methods`, it ensures that `questions`, `options`, and `answers` are managed securely and accessed only through controlled mechanisms.
    
#### **Private Attributes** 🔒
  - User details like `fullname`, `username`, `password`, `role` and `quiz data` are declared as **private** in their respective classes, preventing unauthorized access or modification.
  - `Question Multi` class' private attributes are `question`, `optionA`, `optionB`, `optionC`, `optionD`, `correctAnswer`, `createdBy`, and `subject`.
    
#### **Public Getters and Setter** 🌎
  - **User-Related Getters** 👩🏻‍💻
    - `getUsername()` : Retrieves the user's username.
    - `getPassword()` : Retrieves the user's password.
    - `getFullname()` : Retrieves the user's full name.
    - `getRole()` : Retrieves the role chosen by the user (e.g., student or teacher).
    - `getSubjects()` : Retrieves the user's chosen subject.

  - **Student-Specific Methods** 👩🏻‍🎓
    - `getScores()` : Retrieves the student's score for all subjects.
    - `setScore(int subjectIndex, int score)` : Updates the student's score for a specific subject.

  - **Quiz-Related Getters** ✏️
    - `getQuestion()` : Retrieves the stored quiz questions.
    - `getOptionA()`, `getOptionB()`, `getOptionC()`, `getOptionD()` : Retrieve the options for the multiple-choice quiz questions.
    - `getCorrectAnswer()` : Retrieves the correct answer for a quiz question.
    - `getCreatedBy()` : Retrieves the creator of a specific quiz question.


### 2. **Inheritance** 🌳 
Inheritance is an object-oriented programming principle where a child class inherits attributes and methods from a parent class. This promotes code reuse and establishes a hierarchical relationship between classes. 

  - Used mainly in the `User class`, `Student class`, and `Teacher class` where `User` is the **parent class** and `Student` and `Teacher` are the child classes.

#### **Parent Class (User)** 👵🏼
  - `User` : common attributes like `username`, `password`, `fullname`, `subjects` were encapsulated in the parent class. These attributes represent shared properties that are inherited by specific user types, such as `Student` or `Teacher`, ensuring a consistent structure while allowing for specialized behavior in the child classes.

#### **Child Classes (Student, Teacher)** 👶🏼
  - `Student` : attributes like `username`, `password`, `fullname`, and `subjects`  were inherited from the parent class `User`. Additionaly, an attribute like `score` was introduced uniquely to the student chile class and not inherited from the parent class.
  - `Teacher` : same as the student's classes that were inherited from the parent class `User`.
    
### 3. **Polymorphism** 🔄
Polymorphism is an object-oriented programming principle that allows objects of different types to be treated as objects of a common super type. The two main types of polymorphism are :

  - Compile-time Polymorphism (Method Overloading)
  - Runtime Polymorphism (Method Overriding)

#### **Method Overloading** ⚡
  - Methods like `addQuestion()` and `removeQuestion()` demonstrate method overloading. Each method name is used to edit the teacher-created questions with different parameter lists to handle different scenarios.
      - `addQuestion()` : supports adding pre-defined questions programmatically or interactively creating questions at runtime.
      - `removeQuestion()` : The removeQuestion methods work in tandem to delete questions. The interactive method `(removeQuestion(Teacher teacher, Scanner scanner)` allows teachers to browse through and pick out questions to remove at runtime, thus being user-friendly. While the method `(removeQuestion(QuestionMulti question)` actually deletes the question picked from the system in the background.

#### **Method Overriding** 🎡
  - `register(ArrayList<User> users)` : method is overriden in both `Student` and `Teacher`. Depending on the role that the current user chooses, they use this mrthod to add the current user in the `users arraylist`.
  - `getRole()` : Method is overriden in both child classes. This returns a different role: `"Student"` for the student class and `"Teacher"` for the teacher class.
  - `viewProfile()` : Overriden in both child classes. The base method displays general user profile information, and both subclasses enhance the behavior by adding specific information related to the `Student` or `Teacher` role.
  - `displayRole()` : Both overriden in the child classes also. Displays the `role` depending by the chosen role of the current user.
    
### 4. **Abstraction** 🖼
Abstraction is the concept of hiding implementation details and exposing only the essential features of an object. This is achieved using abstract classes or interfaces, allowing subclasses to define specific behaviors while maintaining a clear, simplified interface.

  - `User Class` : An abstract class that defines the structure for `register()`, `getRole()`, `displayRole()`, and `viewProfile()` methods, leaving the implementation details to the child classes.
  - `Student/Teacher Classes` : These classes provide specific implementations of the abstract methods defined in the `User class`, defining how a student or teacher registers, what their role is, and the functions associated with their roles.
---

# III. Details of the Chosen SDG and Its Integration 🌍
 
The **EduQuiz** project supports **SDG 4: Quality Education** by providing an interactive venue for students to learn and take quizzes on a wide range of subjects. It continuously motivates learners to pursue self-assessment, which is a pillar in the development of education.

Here's how it integrates SDG 4📄✏️

- **Inclusive Education:** The application makes it accessible to all the students irrespective of their location so that they can take quizzes at any time and anywhere. This achieves quality education for everybody. 🌏
- **Personalized Learning:** Students can take quizzes on subjects they are registered for, enabling them to focus on areas they need to improve, thus supporting personalized learning paths. 📈

---

# IV. How To Run

### What You'll Need :
- Visual Studio Code (VS Code)
- Java Development Kit (JDK)
- Java Extension Pack

### Steps to Run the Program 📝
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

# Important Notes 📜

**For OOP**
<br>
Video Presentation is 10:02 long🕦 <br>
Program Run is 04:16 long🕦..
Program Run is for extra only... Its a video that shows how the EduQuiz runs. <br>
(video is in ×1.5 speed, audio is poor coz of laptop's microphone performance) <br>
Link : to be uploaded🚧....
<br>

**For DBMS**
<br>
Video Presentation is 14:13 long🕦 <br>
Link : to be uploaded🚧....
<br>

<p align="center">
<br>
<br>
<br>
<br>.
<br>.
<br>.
<br>≽^•⩊•^≼
  
</p>
