package javadevjournal.design.structural.adapter;

/**
 * @author Kunwar
 */
public class AudioPlayer implements MediaPlayer {
   private MediaAdapter mediaAdapter;
   @Override
   public void playMusic(String audioType, String fileName) {
      //the mp3 format is supported by AudioPlayer itself and it doesn't need adapter here.
      if(audioType.equalsIgnoreCase("mp3")){
         System.out.println("Playing mp3 file: " + fileName);
      }
      //to support other formats, we will need the MediaAdapter
      else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
         mediaAdapter = new MediaAdapter(audioType);
         mediaAdapter.playMusic(audioType, fileName);
      }else{
         System.out.println("The given format: " + audioType + " is not supported");
      }
   }   
}