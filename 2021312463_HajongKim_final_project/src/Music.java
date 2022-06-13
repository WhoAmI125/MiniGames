import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//Run the music for the GUI
public class Music implements Runnable{
		//isLoop is use to set music repeated forever
		private boolean isLoop;
		private File file; //Get the file IO
		private FileInputStream fis;
		private BufferedInputStream bis;
		private static boolean exit = false;
		@Override
		//Run the function
	    public void run() {
			if(exit == false)
			{
				try {
					//Since .jar has limit with what can be used, the FIle and Buffer could not be used
					//Use url instead of file and use clip also instead
		        	URL url = getClass().getResource("music/differenceBGM.wav");
		            AudioInputStream ais;
		            ais = AudioSystem.getAudioInputStream(url);
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
					exit = true;
					clip.loop(Clip.LOOP_CONTINUOUSLY);
		        } catch(Exception e) {
		            System.out.println(e.getMessage());
		        }
			}
	    }
		
		//When the music stop is offered, stop the music
	    public void stopmusic(){
	        try {
	        	URL url = getClass().getResource("music/differenceBGM.wav");
	            AudioInputStream ais;
	            ais = AudioSystem.getAudioInputStream(url);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.stop();
	        } catch(Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	  //When the music stop is offered, stop the music
		public void stop() {
			try {
				exit = true;
				URL url = getClass().getResource("music/differenceBGM.wav");
	            AudioInputStream ais;
	            ais = AudioSystem.getAudioInputStream(url);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.stop();
	        } catch(Exception e) {
	            System.out.println(e.getMessage());
	        }
		}
}
