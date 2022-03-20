package javadevjournal.design.structural.adapter;

/**
 * @author Kunwar
 */
public class AdapterPatternDemo {
   public static void main(String[] args) {
      AudioPlayer audioPlayer = new AudioPlayer();
      audioPlayer.playMusic("mp3", "song1.mp3");
      audioPlayer.playMusic("mp4", "song2.mp4");
      audioPlayer.playMusic("vlc", "song3.vlc");
      audioPlayer.playMusic("xyz", "song4.avi");
   }
}