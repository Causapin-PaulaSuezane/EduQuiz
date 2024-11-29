-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: eduquizdb
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `historypeople`
--

DROP TABLE IF EXISTS `historypeople`;
/*!50001 DROP VIEW IF EXISTS `historypeople`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `historypeople` AS SELECT 
 1 AS `role`,
 1 AS `name`,
 1 AS `subject`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `mathpeople`
--

DROP TABLE IF EXISTS `mathpeople`;
/*!50001 DROP VIEW IF EXISTS `mathpeople`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mathpeople` AS SELECT 
 1 AS `role`,
 1 AS `name`,
 1 AS `subject`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) NOT NULL,
  `question_text` text NOT NULL,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `correct_answer` char(1) NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'History','Why Magellan named Guam the \'Island of thieves\'?','Magellan stole money from that island','The people there stole their boats','The people there are thieves','None of the choices','d','System'),(2,'History','Their outfits were red masks with white triangles and with maroon sash.','Bayani','None of the choices','Katipon','Kawal','a','System'),(3,'History','According to Corazon Aquino\'s Speech she said, \'The dictator had called him a ________. Yet, two million people threw aside their passivity and fear and escorted him to his grave\'.','Traitor','None of the choices','Spy','Nobody','d','System'),(4,'History','\'First Voyage around the World\', \'Kartilya ng Katipunan\' are examples of _______________.','Primary resources','Texts','Secondary resources','None of the choices','a','System'),(5,'History','________________ which were produced by an author who used primary sources to produce the material. In other words, these are historical sources, which studied a certain historical subject.','Resources','Primary sources','None of the choices','Secondary resources','d','System'),(6,'History','In Corazon Aquino\'s speech she quoted, \'Like _______________, I understand that force may be necessary before mercy. Like Lincoln, I don\'t relish it. Yet, I will do whatever it takes to defend the integrity and freedom of my country\'.','Archibald Macleish','Abraham Lincoln','Ninoy Aquino','None of the choices','b','System'),(7,'History','What was the password used for the codes of \'Katipon\'?','Anak ng Bayan','Gomburza','None of the choices','Rizal','a','System'),(8,'History','Sometimes called as \'higher criticism\'.','External Criticism','None of the choices','Criticism','Internal Criticism','d','System'),(9,'History','Are historical sources, which studied a certain historical subject.','Internal Criticism','Secondary Sources','Primary Sources','External Criticism','b','System'),(10,'History','Modern art form that turned away from classical art by exaggerating human features and prodding fun at its subjects.','None of the choices','Abstract','Political caricature','Visual arts','c','System'),(11,'Science','It is a branch of science that deals with the study of matter; its structure, composition, properties, and the changes it undergoes.','Biology','Physics','Chemistry','Mechanics','c','System'),(12,'Science','A kind/type of carbohydrate that is composed of more than two sugar monomers.','Monosaccharides','Disaccharides','Polysaccharides','Lipids','c','System'),(13,'Science','The body-building molecules which help us grow.','Amino acids','Phospholipids','Lipids','Proteins','d','System'),(14,'Science','It is a branch of science that studies life.','Biology','Physics','Mechanics','Chemistry','a','System'),(15,'Science','It is also known as the cardiovascular system, consisting of the heart and blood vessels.','Digestive system','Respiratory system','Nervous system','Circulatory system','d','System'),(16,'Science','These are licensed professionals who create food plans and nutrition programs.','Teacher','Dietitians','Chefs','Doctors','b','System'),(17,'Science','Commonly known as fats or oils.','Carbohydrates','Proteins','Triglycerides','Nucleic acid','c','System'),(18,'Science','Which of the following is the chemical symbol of Silver?','Si','Ag','Pb','S','b','System'),(19,'Science','The study of volcanoes is called ______.','Volcanology','Seismology','Psychology','Oncology','a','System'),(20,'Science','It is the push or pull that causes any change in the motion of an object.','Speed','Acceleration','Force','Motion','c','System'),(21,'Math','Bonnie has twice as many cousins as Robert. George has 5 cousins, which is 9 fewer than Bonnie has. How many cousins does Robert have?','17','22','4','7','d','System'),(22,'Math','Oscar sold 2 plasma televisions for every 5 DLP televisions he sold. If he sold 10 plasma televisions, how many DLP televisions did he sell?','45','20','25','10','c','System'),(23,'Math','Justin earned scores of 85, 92, and 95 on his science tests. What does he need to earn on his next science test so that the average (arithmetic mean) of the four exam scores is 93?','93','100','85','96','b','System'),(24,'Math','Brad\'s class collected 270 used books for the book drive. They packed them in boxes of 30 books each. How many boxes did they need?','240','10','9','5','c','System'),(25,'Math','Joey participated in a dance-a-thon. His team started dancing at 10 a.m. on Friday and stopped at 6 p.m. on Saturday. How many hours did Joey\'s team dance?','52','56','30','32','d','System'),(26,'Math','Lisa was assigned 48 pages to read for English class. She has finished 3/4 of the assignment. How many more pages must she read?','36','21','12','8','c','System'),(27,'Math','One batch of scones will provide enough for 3/11 of Beth\'s Sunday brunch gathering of 44 people. If she bakes five batches of scones, how many additional people could she feed?','16','11','8','60','a','System'),(28,'Math','Josh practiced his clarinet for 5/6 of an hour. How many minutes did he practice?','83','50','8.3','55','b','System'),(29,'Math','Refinancing a home loan amounted to reducing the monthly payment by 1/9 of the present monthly payment. If the new monthly payment is $1,128, how much was the original monthly payment?','$1,340','$1,213','$1,269','$1,225','c','System'),(30,'Math','How many eighths are in 4 and 5/8?','45','48','37','9','c','System'),(38,'Math','What is 2+2?','3','4','5','6','b','jones_m'),(39,'Math','What is the square root of 16?','2','3','4','5','c','white_a'),(40,'Science','What planet is known as the Red Planet?','Earth','Mars','Jupiter','Saturn','b','brown_l'),(41,'Science','What is the chemical symbol for water?','HO','O2','H2O','CO2','c','jones_m'),(42,'History','Who was the first president of the United States?','George Washington','Abraham Lincoln','Thomas Jefferson','John Adams','a','clark_s'),(43,'History','What year did World War II end?','1943','1944','1945','1946','c','brown_l'),(44,'history','The Rizal family had 11 siblings, of whom Rizal was the seventh. One of his siblings died early and is said to have been Rizal\'s \'first sorrow\'. Who was this sibling?','Concepcion','Josefa','Narcisa','Lucia','a','Lhoriemae Sanchez'),(45,'science','A single DNA is called ________.','Nucleus','Ribosome','Cytoplasm','Chromosome','d','Marie Koli Ocampo');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `sciencepeople`
--

DROP TABLE IF EXISTS `sciencepeople`;
/*!50001 DROP VIEW IF EXISTS `sciencepeople`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `sciencepeople` AS SELECT 
 1 AS `role`,
 1 AS `name`,
 1 AS `subject`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `student_score`
--

DROP TABLE IF EXISTS `student_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_score` (
  `username` varchar(100) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `score` int DEFAULT NULL,
  `date_taken` date DEFAULT NULL,
  PRIMARY KEY (`username`,`subject`),
  KEY `subject` (`subject`),
  CONSTRAINT `student_score_ibfk_1` FOREIGN KEY (`username`) REFERENCES `students` (`username`),
  CONSTRAINT `student_score_ibfk_2` FOREIGN KEY (`subject`) REFERENCES `subjects` (`subject_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_score`
--

LOCK TABLES `student_score` WRITE;
/*!40000 ALTER TABLE `student_score` DISABLE KEYS */;
INSERT INTO `student_score` VALUES ('anya_12','History',1,'2024-11-28'),('anya_12','Math',5,'2024-11-27'),('anya_12','Science',1,'2024-11-27'),('jane_smith','History',6,'2024-11-10'),('jane_smith','Math',9,'2024-09-18'),('john_doe','Math',8,'2024-09-15'),('john_doe','Science',7,'2024-10-05'),('lucy_adams','History',8,'2024-09-25'),('lucy_adams','Math',7,'2024-11-01'),('mark_evans','Science',5,'2024-10-10'),('miaka.1','Science',4,'2024-11-29'),('sam_taylor','Science',10,'2024-10-20');
/*!40000 ALTER TABLE `student_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_subjects`
--

DROP TABLE IF EXISTS `student_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_subjects` (
  `student_username` varchar(255) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  KEY `student_username` (`student_username`),
  KEY `subject_name` (`subject_name`),
  CONSTRAINT `student_subjects_ibfk_1` FOREIGN KEY (`student_username`) REFERENCES `students` (`username`),
  CONSTRAINT `student_subjects_ibfk_2` FOREIGN KEY (`subject_name`) REFERENCES `subjects` (`subject_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_subjects`
--

LOCK TABLES `student_subjects` WRITE;
/*!40000 ALTER TABLE `student_subjects` DISABLE KEYS */;
INSERT INTO `student_subjects` VALUES ('john_doe','Math'),('john_doe','Science'),('jane_smith','Math'),('jane_smith','History'),('sam_taylor','Science'),('lucy_adams','History'),('lucy_adams','Math'),('mark_evans','Science'),('anya_12','Math'),('anya_12','Science'),('anya_12','History'),('miaka.1','Science'),('miaka.1','History');
/*!40000 ALTER TABLE `student_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('anya_12','forger12','Anya Forger'),('jane_smith','pass456','Jane Smith'),('john_doe','pass123','John Doe'),('lucy_adams','pass321','Lucy Adams'),('mark_evans','pass654','Mark Evans'),('miaka.1','miaka!12','Miaka Sanchez'),('sam_taylor','pass789','Sam Taylor');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `subject_name` varchar(50) NOT NULL,
  PRIMARY KEY (`subject_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES ('History'),('Math'),('Science');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_subjects`
--

DROP TABLE IF EXISTS `teacher_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_subjects` (
  `teacher_username` varchar(255) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  KEY `teacher_username` (`teacher_username`),
  KEY `subject_name` (`subject_name`),
  CONSTRAINT `teacher_subjects_ibfk_1` FOREIGN KEY (`teacher_username`) REFERENCES `teachers` (`username`),
  CONSTRAINT `teacher_subjects_ibfk_2` FOREIGN KEY (`subject_name`) REFERENCES `subjects` (`subject_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_subjects`
--

LOCK TABLES `teacher_subjects` WRITE;
/*!40000 ALTER TABLE `teacher_subjects` DISABLE KEYS */;
INSERT INTO `teacher_subjects` VALUES ('jones_m','Math'),('jones_m','Science'),('clark_s','History'),('white_a','Math'),('brown_l','Science'),('brown_l','History'),('Lhorie14','Math'),('Lhorie14','History'),('m_koli','Science');
/*!40000 ALTER TABLE `teacher_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES ('brown_l','teach123','Laura Brown'),('clark_s','teach654','Sarah Clark'),('jones_m','teach987','Michael Jones'),('Lhorie14','portable12','Lhoriemae Sanchez'),('m_koli','m_koli54','Marie Koli Ocampo'),('white_a','teach321','Andrew White');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `historypeople`
--

/*!50001 DROP VIEW IF EXISTS `historypeople`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `historypeople` AS select 'Student' AS `role`,`s`.`full_name` AS `name`,`ss`.`subject_name` AS `subject` from (`students` `s` join `student_subjects` `ss` on((`s`.`username` = `ss`.`student_username`))) where (`ss`.`subject_name` = 'History') union select 'Teacher' AS `role`,`t`.`full_name` AS `name`,`tt`.`subject_name` AS `subject` from (`teachers` `t` join `teacher_subjects` `tt` on((`t`.`username` = `tt`.`teacher_username`))) where (`tt`.`subject_name` = 'History') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mathpeople`
--

/*!50001 DROP VIEW IF EXISTS `mathpeople`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mathpeople` AS select 'Student' AS `role`,`s`.`full_name` AS `name`,`ss`.`subject_name` AS `subject` from (`students` `s` join `student_subjects` `ss` on((`s`.`username` = `ss`.`student_username`))) where (`ss`.`subject_name` = 'Math') union select 'Teacher' AS `role`,`t`.`full_name` AS `name`,`tt`.`subject_name` AS `subject` from (`teachers` `t` join `teacher_subjects` `tt` on((`t`.`username` = `tt`.`teacher_username`))) where (`tt`.`subject_name` = 'Math') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `sciencepeople`
--

/*!50001 DROP VIEW IF EXISTS `sciencepeople`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `sciencepeople` AS select 'Student' AS `role`,`s`.`full_name` AS `name`,`ss`.`subject_name` AS `subject` from (`students` `s` join `student_subjects` `ss` on((`s`.`username` = `ss`.`student_username`))) where (`ss`.`subject_name` = 'Science') union select 'Teacher' AS `role`,`t`.`full_name` AS `name`,`tt`.`subject_name` AS `subject` from (`teachers` `t` join `teacher_subjects` `tt` on((`t`.`username` = `tt`.`teacher_username`))) where (`tt`.`subject_name` = 'Science') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-29 16:33:07
