package javadevjournal.design.structural.Bridge;

/**
 * @author Kunwar
 */
public class QuestionManager {
    protected IQuestion question;
    public String catalog;

    public QuestionManager(String catalog) {
        this.catalog = catalog;
    }

    public void next() {
        question.nextQuestion();
    }

    public void previous() {
        question.previousQuestion();
    }

    public void newOne(String quest) {
        question.newQuestion(quest);
    }

    public void delete(String quest) {
        question.deleteQuestion(quest);
    }

    public void display() {
        question.displayQuestion();
    }

    public void displayAll() {
        System.out.println("Question Paper: " + catalog);
        question.displayAllQuestions();
    }
}