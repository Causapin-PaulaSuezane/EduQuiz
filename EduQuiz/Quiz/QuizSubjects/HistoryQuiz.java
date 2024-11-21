package Quiz.QuizSubjects;

import java.util.ArrayList;

import Quiz.QuestionMulti;
import Quiz.QuizUtils;

public class HistoryQuiz {

    static {
        QuizUtils.addQuestion("History", new QuestionMulti("Why Magellan named Guam the 'Island of thieves'?",
            "Magellan stole money from that island", "The people there stole their boats", "The people there are thieves", "None of the choices", "d", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("Their outfits were red masks with white triangles and with maroon sash.",
            "Bayani", "None of the choices", "Katipon", "Kawal", "a", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("According to Corazon Aquino's Speech she said, 'The dictator had called him a ________. Yet, two million people threw aside their passivity and fear and escorted him to his grave'.",
            "Traitor", "None of the choices", "Spy", "Nobody", "d", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("'First Voyage around the World', 'Kartilya ng Katipunan' are examples of _______________.",
            "Primary resources", "Texts", "Secondary resources", "None of the choices", "a", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("________________ which were produced by an author who used primary sources to produce the material. In other words, these are historical sources, which studied a certain historical subject.",
            "Resources", "Primary sources", "None of the choices", "Secondary resources", "d", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("In Corazon Aquino's speech she quoted, 'Like _______________, I understand that force may be necessary before mercy. Like Lincoln, I don't relish it. Yet, I will do whatever it takes to defend the integrity and freedom of my country'.",
            "Archibald Macleish", "Abraham Lincoln", "Ninoy Aquino", "None of the choices", "b", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("What was the password used for the codes of 'Katipon'?",
            "Anak ng Bayan", "Gomburza", "None of the choices", "Rizal", "a", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("Sometimes called as 'higher criticism'.",
            "External Criticism", "None of the choices", "Criticism", "Internal Criticism", "d", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("Are historical sources, which studied a certain historical subject.",
            "Internal Criticism", "Secondary Sources", "Primary Sources", "External Criticism", "b", "System", "History"));

        QuizUtils.addQuestion("History", new QuestionMulti("Modern art form that turned away from classical art by exaggerating human features and prodding fun at its subjects.",
            "None of the choices", "Abstract", "Political caricature", "Visual arts", "c", "System", "History"));
    }

    // so we can call out all the history questions
    public static ArrayList<QuestionMulti> getQuestions() {
        return QuizUtils.getQuestionsBySubject("History");
    }
}