package javadevjournal.design.structural.Bridge;

/**
 * @author Kunwar
 */
public interface IQuestion {
    public void nextQuestion();

    public void previousQuestion();

    public void newQuestion(String q);

    public void deleteQuestion(String q);

    public void displayQuestion();

    public void displayAllQuestions();
}  