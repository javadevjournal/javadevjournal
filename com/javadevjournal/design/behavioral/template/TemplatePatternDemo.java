package main.com.kunwar.designpatterns.behavioral.template;

/**
 * @author Kunwar
 */
public class TemplatePatternDemo {
   public static void main(String[] args) {
      Game game = new Cricket();
      game.play();
      System.out.println();
      game = new Football();
      game.play();
      System.out.println();
      game = new Hockey();
      game.play();
      System.out.println();
      game = new Volleyball();
      game.play();
   }
}
