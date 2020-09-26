package invader;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Music implements Runnable{

	public static void playMusic(String filePath) {
		
		 try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		  
		        Thread.sleep(clip.getMicrosecondLength());
		    }
		 catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
	
	}
	
	public static void main(String[] args) {
		Music.playMusic("/Users/ole-magnusnorum/Desktop/java/games/src/invader/shooting-stars-8-bit-tribute-to-bag-raiders-8-bit-universe.wav");
	}

	@Override
	public void run() {
		playMusic("/Users/ole-magnusnorum/Desktop/java/games/src/invader/shooting-stars-8-bit-tribute-to-bag-raiders-8-bit-universe.wav");
		
	}
}


