package javadevjournal.design.structural.Bridge;

/**
 * @author Kunwar
 */
public class BridgePatternClient {
    public static void main(String[] args) {
        QuestionFormat questions = new QuestionFormat("Java Programming Language");
        questions.question = new JavaQuestions();
        questions.display();
        questions.previous();

        questions.next();
        questions.display();

        questions.next();
        questions.display();

        questions.previous();
        questions.display();

        questions.newOne("What is inheritance? ");
        questions.newOne("How many types of inheritance are there in java?");

        questions.displayAll();
    }
}