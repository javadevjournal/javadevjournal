package main.com.kunwar.designpatterns.behavioral.template;

/**
 * @author Kunwar
 */
public abstract class Game {
   abstract void initialize();
   abstract void startPlay();
   abstract void endPlay();

   //template method
   public final void play(){
      //initialize the game
      initialize();
      //start game
      startPlay();
      //end game
      endPlay();
   }
}