package javadevjournal.design.structural.Bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kunwar
 */
public class JavaQuestions implements IQuestion {

    private List<String> questionsList = new ArrayList<String>();
    private int currQuesCounter = 0;

    public JavaQuestions() {
        questionsList.add("What is class? ");
        questionsList.add("What is interface? ");
        questionsList.add("What is abstraction? ");
        questionsList.add("How multiple polymorphism is achieved in java? ");
        questionsList.add("How many types of exception  handling are there in java? ");
        questionsList.add("Define the keyword final for  variable, method, and class in java? ");
        questionsList.add("What is abstract class? ");
        questionsList.add("What is multi-threading? ");
    }

    public void nextQuestion() {
        if (currQuesCounter <= questionsList.size() - 1) {
            currQuesCounter++;
        } else {
            System.out.println("We are already at the last question");
        }

    }

    public void previousQuestion() {
        if (currQuesCounter > 0) {
            currQuesCounter--;
        } else {
            System.out.println("We are already at the first question");
        }
    }

    public void newQuestion(String question) {
        questionsList.add(question);
    }

    public void deleteQuestion(String question) {
        questionsList.remove(question);
    }

    public void displayQuestion() {
        System.out.println(questionsList.get(currQuesCounter));
    }

    public void displayAllQuestions() {
        for (String question : questionsList) {
            System.out.println(question);
        }
    }
}