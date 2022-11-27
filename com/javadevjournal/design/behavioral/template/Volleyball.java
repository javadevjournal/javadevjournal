package main.com.kunwar.designpatterns.behavioral.template;

/**
 * @author Kunwar
 */
public class Volleyball extends Game {

   @Override
   void endPlay() {
      System.out.println("Volleyball Game Finished!");
   }

   @Override
   void initialize() {
      System.out.println("Volleyball Game Initialized! Start playing.");
   }

   @Override
   void startPlay() {
      System.out.println("Volleyball Game Started. Enjoy the game!");
   }
}