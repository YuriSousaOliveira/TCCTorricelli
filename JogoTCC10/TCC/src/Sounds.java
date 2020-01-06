import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;


public class Sounds extends JFrame {
	   
	   
	   public Sounds() {
	     
	      try {
	   
	         URL url = this.getClass().getClassLoader().getResource("Audio/1.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	      
	         Clip clip = AudioSystem.getClip();
	   
	         clip.open(audioIn);
	         clip.start();
	         clip.loop(Clip.LOOP_CONTINUOUSLY); 
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void main(String[] args) {
	      new Sounds();
	   }
	}