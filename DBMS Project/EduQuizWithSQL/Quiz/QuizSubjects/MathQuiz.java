package Quiz.QuizSubjects;

import java.util.ArrayList;

import Database.QuestionDatabaseHandler;
import Quiz.QuestionMulti;
import Quiz.QuizUtils;

public class MathQuiz {

    static {
        QuizUtils.addQuestion("Math", new QuestionMulti("Bonnie has twice as many cousins as Robert. George has 5 cousins, which is 9 fewer than Bonnie has. How many cousins does Robert have?",
                "17", "22", "4", "7", "d", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("Oscar sold 2 plasma televisions for every 5 DLP televisions he sold. If he sold 10 plasma televisions, how many DLP televisions did he sell?",
                "45", "20", "25", "10", "c", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("Justin earned scores of 85, 92, and 95 on his science tests. What does he need to earn on his next science test so that the average (arithmetic mean) of the four exam scores is 93?",
                "93", "100", "85", "96", "b", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("Brad\'s class collected 270 used books for the book drive. They packed them in boxes of 30 books each. How many boxes did they need?",
                "240", "10", "9", "5", "c", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("Joey participated in a dance-a-thon. His team started dancing at 10 a.m. on Friday and stopped at 6 p.m. on Saturday. How many hours did Joey\'s team dance?",
                "52", "56", "30", "32", "d", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("Lisa was assigned 48 pages to read for English class. She has finished 3/4 of the assignment. How many more pages must she read?",
                "36", "21", "12", "8", "c", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("One batch of scones will provide enough for 3/11 of Beth\'s Sunday brunch gathering of 44 people. If she bakes five batches of scones, how many additional people could she feed?",
                "16", "11", "8", "60", "a", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("Josh practiced his clarinet for 5/6 of an hour. How many minutes did he practice?",
                "83", "50", "8.3", "55", "b", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("Refinancing a home loan amounted to reducing the monthly payment by 1/9 of the present monthly payment. If the new monthly payment is $1,128, how much was the original monthly payment?",
                "$1,340", "$1,213", "$1,269", "$1,225", "c", "System", "Math"));

        QuizUtils.addQuestion("Math", new QuestionMulti("How many eighths are in 4 and 5/8?",
                "45", "48", "37", "9", "c", "System", "Math"));
    }

    public static ArrayList<QuestionMulti> getQuestions() {
        return QuizUtils.getQuestionsBySubject("Math");
    }

     public static void uploadQuestionsToDatabase() {
        ArrayList<QuestionMulti> questions = getQuestions();
        for (QuestionMulti question : questions) {
            QuestionDatabaseHandler.insertQuestion(question, "Math");
        }
    }
}
