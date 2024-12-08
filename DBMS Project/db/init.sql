CREATE DATABASE if not exists eduquizdb;

USE eduquizdb;

CREATE TABLE subjects (
    subject_name VARCHAR(50) PRIMARY KEY
);
INSERT INTO subjects (subject_name) VALUES ('Math'), ('Science'), ('History');

CREATE TABLE students (
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100),
    full_name VARCHAR(100) 
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
    full_name VARCHAR(100) 
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

----------------------------------------------- VIEW TABLE -----------------------------------------------------------

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

----------------------------------------------------------- DATA -----------------------------------------------------------
INSERT INTO `students` VALUES ('anya_12','forger12','Anya Forger'),('jane_smith','pass456','Jane Smith'),('john_doe','pass123','John Doe'),('lucy_adams','pass321','Lucy Adams'),('mark_evans','pass654','Mark Evans'),('miaka.1','miaka!12','Miaka Sanchez'),('Pola Causapin','123','Pola Causapin'),('sam_taylor','pass789','Sam Taylor');
INSERT INTO `student_subjects` VALUES ('john_doe','Math'),('john_doe','Science'),('jane_smith','Math'),('jane_smith','History'),('sam_taylor','Science'),('lucy_adams','History'),('lucy_adams','Math'),('mark_evans','Science'),('anya_12','Math'),('anya_12','Science'),('anya_12','History'),('miaka.1','Science'),('miaka.1','History'),('Pola Causapin','Science');
INSERT INTO `student_score` VALUES ('anya_12','History',1,'2024-11-28'),('anya_12','Math',5,'2024-11-27'),('anya_12','Science',1,'2024-11-27'),('jane_smith','History',6,'2024-11-10'),('jane_smith','Math',9,'2024-09-18'),('john_doe','Math',8,'2024-09-15'),('john_doe','Science',7,'2024-10-05'),('lucy_adams','History',8,'2024-09-25'),('lucy_adams','Math',7,'2024-11-01'),('mark_evans','Science',5,'2024-10-10'),('miaka.1','Science',3,'2024-11-29'),('sam_taylor','Science',10,'2024-10-20');
INSERT INTO `teachers` VALUES ('brown_l','teach123','Laura Brown'),('clark_s','teach654','Sarah Clark'),('jones_m','teach987','Michael Jones'),('Lhorie14','portable12','Lhoriemae Sanchez'),('m_koli','m_koli54','Marie Koli Ocampo'),('white_a','teach321','Andrew White');
INSERT INTO `teacher_subjects` VALUES ('jones_m','Math'),('jones_m','Science'),('clark_s','History'),('white_a','Math'),('brown_l','Science'),('brown_l','History'),('Lhorie14','Math'),('Lhorie14','History'),('m_koli','Science');
INSERT INTO `questions` VALUES (1,'History','Why Magellan named Guam the \'Island of thieves\'?','Magellan stole money from that island','The people there stole their boats','The people there are thieves','None of the choices','d','System'),(2,'History','Their outfits were red masks with white triangles and with maroon sash.','Bayani','None of the choices','Katipon','Kawal','a','System'),(3,'History','According to Corazon Aquino\'s Speech she said, \'The dictator had called him a ________. Yet, two million people threw aside their passivity and fear and escorted him to his grave\'.','Traitor','None of the choices','Spy','Nobody','d','System'),(4,'History','\'First Voyage around the World\', \'Kartilya ng Katipunan\' are examples of _______________.','Primary resources','Texts','Secondary resources','None of the choices','a','System'),(5,'History','________________ which were produced by an author who used primary sources to produce the material. In other words, these are historical sources, which studied a certain historical subject.','Resources','Primary sources','None of the choices','Secondary resources','d','System'),(6,'History','In Corazon Aquino\'s speech she quoted, \'Like _______________, I understand that force may be necessary before mercy. Like Lincoln, I don\'t relish it. Yet, I will do whatever it takes to defend the integrity and freedom of my country\'.','Archibald Macleish','Abraham Lincoln','Ninoy Aquino','None of the choices','b','System'),(7,'History','What was the password used for the codes of \'Katipon\'?','Anak ng Bayan','Gomburza','None of the choices','Rizal','a','System'),(8,'History','Sometimes called as \'higher criticism\'.','External Criticism','None of the choices','Criticism','Internal Criticism','d','System'),(9,'History','Are historical sources, which studied a certain historical subject.','Internal Criticism','Secondary Sources','Primary Sources','External Criticism','b','System'),(10,'History','Modern art form that turned away from classical art by exaggerating human features and prodding fun at its subjects.','None of the choices','Abstract','Political caricature','Visual arts','c','System'),(11,'Science','It is a branch of science that deals with the study of matter; its structure, composition, properties, and the changes it undergoes.','Biology','Physics','Chemistry','Mechanics','c','System'),(12,'Science','A kind/type of carbohydrate that is composed of more than two sugar monomers.','Monosaccharides','Disaccharides','Polysaccharides','Lipids','c','System'),(13,'Science','The body-building molecules which help us grow.','Amino acids','Phospholipids','Lipids','Proteins','d','System'),(14,'Science','It is a branch of science that studies life.','Biology','Physics','Mechanics','Chemistry','a','System'),(15,'Science','It is also known as the cardiovascular system, consisting of the heart and blood vessels.','Digestive system','Respiratory system','Nervous system','Circulatory system','d','System'),(16,'Science','These are licensed professionals who create food plans and nutrition programs.','Teacher','Dietitians','Chefs','Doctors','b','System'),(17,'Science','Commonly known as fats or oils.','Carbohydrates','Proteins','Triglycerides','Nucleic acid','c','System'),(18,'Science','Which of the following is the chemical symbol of Silver?','Si','Ag','Pb','S','b','System'),(19,'Science','The study of volcanoes is called ______.','Volcanology','Seismology','Psychology','Oncology','a','System'),(20,'Science','It is the push or pull that causes any change in the motion of an object.','Speed','Acceleration','Force','Motion','c','System'),(21,'Math','Bonnie has twice as many cousins as Robert. George has 5 cousins, which is 9 fewer than Bonnie has. How many cousins does Robert have?','17','22','4','7','d','System'),(22,'Math','Oscar sold 2 plasma televisions for every 5 DLP televisions he sold. If he sold 10 plasma televisions, how many DLP televisions did he sell?','45','20','25','10','c','System'),(23,'Math','Justin earned scores of 85, 92, and 95 on his science tests. What does he need to earn on his next science test so that the average (arithmetic mean) of the four exam scores is 93?','93','100','85','96','b','System'),(24,'Math','Brad\'s class collected 270 used books for the book drive. They packed them in boxes of 30 books each. How many boxes did they need?','240','10','9','5','c','System'),(25,'Math','Joey participated in a dance-a-thon. His team started dancing at 10 a.m. on Friday and stopped at 6 p.m. on Saturday. How many hours did Joey\'s team dance?','52','56','30','32','d','System'),(26,'Math','Lisa was assigned 48 pages to read for English class. She has finished 3/4 of the assignment. How many more pages must she read?','36','21','12','8','c','System'),(27,'Math','One batch of scones will provide enough for 3/11 of Beth\'s Sunday brunch gathering of 44 people. If she bakes five batches of scones, how many additional people could she feed?','16','11','8','60','a','System'),(28,'Math','Josh practiced his clarinet for 5/6 of an hour. How many minutes did he practice?','83','50','8.3','55','b','System'),(29,'Math','Refinancing a home loan amounted to reducing the monthly payment by 1/9 of the present monthly payment. If the new monthly payment is $1,128, how much was the original monthly payment?','$1,340','$1,213','$1,269','$1,225','c','System'),(30,'Math','How many eighths are in 4 and 5/8?','45','48','37','9','c','System'),(38,'Math','What is 2+2?','3','4','5','6','b','jones_m'),(39,'Math','What is the square root of 16?','2','3','4','5','c','white_a'),(40,'Science','What planet is known as the Red Planet?','Earth','Mars','Jupiter','Saturn','b','brown_l'),(41,'Science','What is the chemical symbol for water?','HO','O2','H2O','CO2','c','jones_m'),(42,'History','Who was the first president of the United States?','George Washington','Abraham Lincoln','Thomas Jefferson','John Adams','a','clark_s'),(43,'History','What year did World War II end?','1943','1944','1945','1946','c','brown_l'),(44,'history','The Rizal family had 11 siblings, of whom Rizal was the seventh. One of his siblings died early and is said to have been Rizal\'s \'first sorrow\'. Who was this sibling?','Concepcion','Josefa','Narcisa','Lucia','a','Lhoriemae Sanchez'),(45,'science','A single DNA is called ________.','Nucleus','Ribosome','Cytoplasm','Chromosome','d','Marie Koli Ocampo');


----------------------------------------------------------- SHOW -----------------------------------------------------------

SELECT * FROM students;
SELECT * FROM student_subjects;
SELECT * FROM student_score;

SELECT * FROM subjects;
SELECT * FROM questions;

SELECT * FROM teachers;
SELECT * FROM teacher_subjects;

SELECT * FROM HistoryPeople;
SELECT * FROM MathPeople;
SELECT * FROM SciencePeople;