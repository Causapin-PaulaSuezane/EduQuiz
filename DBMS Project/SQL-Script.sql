CREATE DATABASE if not exists eduquizdb;

USE eduquizdb;

CREATE TABLE subjects (
    subject_name VARCHAR(50) PRIMARY KEY
);
INSERT INTO subjects (subject_name) VALUES ('Math'), ('Science'), ('History');

CREATE TABLE students (
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100),
    full_name VARCHAR(100) PRIMARY KEY
);

CREATE TABLE student_subjects (
    student_username VARCHAR(255),
    subject_name VARCHAR(255),
    FOREIGN KEY (student_username) REFERENCES students(username),
    FOREIGN KEY (subject_name) REFERENCES subjects(subject_name)
);

CREATE TABLE student_score (
    username VARCHAR(100),
    subject VARCHAR(50),
    score INT,
    date_taken DATE,
    PRIMARY KEY (username, subject),
    FOREIGN KEY (username) REFERENCES students(username),
    FOREIGN KEY (subject) REFERENCES subjects(subject_name)
);

CREATE TABLE teachers(
	username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100),
    full_name VARCHAR(100) PRIMARY KEY
);

CREATE TABLE teacher_subjects (
    teacher_username VARCHAR(255),
    subject_name VARCHAR(255),
    FOREIGN KEY (teacher_username) REFERENCES teachers(username),
    FOREIGN KEY (subject_name) REFERENCES subjects(subject_name)
);


CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject VARCHAR(50) NOT NULL,
    question_text TEXT NOT NULL,
    choice_a VARCHAR(255),
    choice_b VARCHAR(255),
    choice_c VARCHAR(255),
    choice_d VARCHAR(255),
    correct_answer CHAR(1) NOT NULL,
    created_by VARCHAR(50)
);

-----------------------------------------------

CREATE VIEW HistoryPeople AS
SELECT 
    'Student' AS role,
    s.full_name AS name,
    ss.subject_name AS subject
FROM 
    students s
JOIN 
    student_subjects ss ON s.username = ss.student_username
WHERE 
    ss.subject_name = 'History'
UNION
SELECT 
    'Teacher' AS role,
    t.full_name AS name,
    tt.subject_name AS subject
FROM 
    teachers t
JOIN 
    teacher_subjects tt ON t.username = tt.teacher_username
WHERE 
    tt.subject_name = 'History';

----------------------------------------------

CREATE VIEW MathPeople AS
SELECT 
    'Student' AS role,
    s.full_name AS name,
    ss.subject_name AS subject
FROM 
    students s
JOIN 
    student_subjects ss ON s.username = ss.student_username
WHERE 
    ss.subject_name = 'Math'
UNION
SELECT 
    'Teacher' AS role,
    t.full_name AS name,
    tt.subject_name AS subject
FROM 
    teachers t
JOIN 
    teacher_subjects tt ON t.username = tt.teacher_username
WHERE 
    tt.subject_name = 'Math';

------------------------------------------------

CREATE VIEW SciencePeople AS
SELECT 
    'Student' AS role,
    s.full_name AS name,
    ss.subject_name AS subject
FROM 
    students s
JOIN 
    student_subjects ss ON s.username = ss.student_username
WHERE 
    ss.subject_name = 'Science'
UNION
SELECT 
    'Teacher' AS role,
    t.full_name AS name,
    tt.subject_name AS subject
FROM 
    teachers t
JOIN 
    teacher_subjects tt ON t.username = tt.teacher_username
WHERE 
    tt.subject_name = 'Science';

-----------------------------------------------------------

SELECT * FROM students;
SELECT * FROM student_subjects;
SELECT * FROM student_score;

SELECT * FROM subjects;
SELECT * FROM questions;

SELECT * FROM teachers;
SELECT * FROM teacher_subjects;

SHOW CREATE TABLE teachers;
SHOW CREATE TABLE students;
SHOW COLUMNS FROM subjects;
SHOW COLUMNS FROM student_subjects;
SHOW COLUMNS FROM teacher_subjects;
SHOW CREATE TABLE student_score;

SELECT * FROM HistoryPeople;
SELECT * FROM MathPeople;
SELECT * FROM SciencePeople;
