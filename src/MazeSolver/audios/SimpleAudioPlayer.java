
package mazesolver.audios;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SimpleAudioPlayer {
   
    static Long currentFrame;
   static Clip clip;
     
   
    String status;
     
    AudioInputStream audioInputStream;
    public static String filePath;
    public static void LoadSound(){
   
   filePath="C:\\Users\\Mehed\\Documents\\NetBeansProjects\\Java_game-master\\src\\res\\sound\\menu.wav";
    SimpleAudioPlayer audioPlayer = new SimpleAudioPlayer();
    
    audioPlayer.play();
   
    }
    
    
    
    public SimpleAudioPlayer() {
         
    	
    	try{
    	
            audioInputStream = 
                    AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
             
           
            clip = AudioSystem.getClip();
             
            
            clip.open(audioInputStream);
             
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(Exception e) {
        	
        	
        	
        }
    	}
   
    public void play() 
    {
        //start the clip
        clip.start();
         
        status = "play";
    }
   
    public void pause() 
    {
        if (status.equals("paused")) 
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = 
        this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }
     
    
    public void resumeAudio() throws UnsupportedAudioFileException,
                                IOException, LineUnavailableException 
    {
        if (status.equals("play")) 
        {
            System.out.println("Audio is already "+
            "being played");
            return;
        }
        clip.close();
       resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }
     
     
    
    public static void stop() 
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }
     
     
    
    public void resetAudioStream() 
    {
        try {
			audioInputStream = AudioSystem.getAudioInputStream(
			new File(filePath).getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}

