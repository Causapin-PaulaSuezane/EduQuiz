package Quiz.QuizSubjects;

import java.util.ArrayList;

import Quiz.QuestionMulti;
import Quiz.QuizUtils;

public class ScienceQuiz {

    static {
        QuizUtils.addQuestion("Science", new QuestionMulti("It is a branch of science that deals with the study of matter; its structure, composition, properties, and the changes it undergoes.",
                "Biology", "Physics", "Chemistry", "Mechanics", "c", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("A kind/type of carbohydrate that is composed of more than two sugar monomers.",
                "Monosaccharides", "Disaccharides", "Polysaccharides", "Lipids", "c", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("The body-building molecules which help us grow.",
                "Amino acids", "Phospholipids", "Lipids", "Proteins", "d", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("It is a branch of science that studies life.",
                "Biology", "Physics", "Mechanics", "Chemistry", "a", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("It is also known as the cardiovascular system, consisting of the heart and blood vessels.",
                "Digestive system", "Respiratory system", "Nervous system", "Circulatory system", "d", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("These are licensed professionals who create food plans and nutrition programs.",
                "Teacher", "Dietitians", "Chefs", "Doctors", "b", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("Commonly known as fats or oils.",
                "Carbohydrates", "Proteins", "Triglycerides", "Nucleic acid", "c", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("Which of the following is the chemical symbol of Silver?",
                "Si", "Ag", "Pb", "S", "b", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("The study of volcanoes is called ______.",
                "Volcanology", "Seismology", "Psychology", "Oncology", "a", "System", "Science"));

        QuizUtils.addQuestion("Science", new QuestionMulti("It is the push or pull that causes any change in the motion of an object.",
                "Speed", "Acceleration", "Force", "Motion", "c", "System", "Science"));
    }

    // so we can call out all the science questions
    public static ArrayList<QuestionMulti> getQuestions() {
        return QuizUtils.getQuestionsBySubject("Science");
    }
}
