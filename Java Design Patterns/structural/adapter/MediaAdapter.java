package javadevjournal.design.structural.adapter;

/**
 * @author Kunwar
 */
public class MediaAdapter implements MediaPlayer {

   public static final String VLC = "vlc";
   public static final String MP_4 = "mp4";

   private AdvancedMediaPlayer advancedMusicPlayer;
   public MediaAdapter(String audioType){
      if(audioType.equalsIgnoreCase(VLC) ){
         advancedMusicPlayer = new VlcMusicPlayer();
      }else if (audioType.equalsIgnoreCase(MP_4)){
         advancedMusicPlayer = new Mp4MusicPlayer();
      }	
   }

   @Override
   public void playMusic(String audioType, String fileName) {
      if(audioType.equalsIgnoreCase(VLC)){
         advancedMusicPlayer.playVlcPlayer(fileName);
      }else if(audioType.equalsIgnoreCase(MP_4)){
         advancedMusicPlayer.playMp4Player(fileName);
      }
   }
}