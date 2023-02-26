package main.com.kunwar.designpatterns.behavioral.template;

/**
 * @author Kunwar
 */
public class Hockey extends Game {

   @Override
   void endPlay() {
      System.out.println("Hockey Game Finished!");
   }

   @Override
   void initialize() {
      System.out.println("Hockey Game Initialized! Start playing.");
   }

   @Override
   void startPlay() {
      System.out.println("Hockey Game Started. Enjoy the game!");
   }
}