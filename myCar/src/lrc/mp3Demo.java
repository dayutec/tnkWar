package lrc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class mp3Demo {

	public final Pattern pattern = Pattern.compile("(?<=//[).*?(?=//])");
	
	File file = new File("C://Users//eyuuyee//Music//0541.mp3");
	public FileInputStream fis;
	public BufferedInputStream BIS;
	public SourceDataLine dataLine;
	public AudioFormat fileFormat;
	public ArrayList<Code> lrc = new ArrayList<Code>();
	
	public Player player;
	private long pausePosition;
	private long songLength;
	private boolean palyedBoolean=false;
	
	public mp3Demo(){
		
	}
	
	public String songName;
	
	public ArrayList<Code> readFile() {
		File file = new File("C://Users//eyuuyee//Music//233212.lrc");
		try {
			fis = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					fis));
			String lrcString = null;
			while ((lrcString = reader.readLine()) != null)
				parseLine(lrcString);
		} catch (FileNotFoundException e) {
		
		} catch (IOException e) {

		}
		
		return lrc;
	}
	
	public void parseLine(String line) {
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String time = matcher.group();
			String str = line.substring(line.indexOf(time) + time.length() + 1);
			Code code = new Code(strToLong(time), str);
			lrc.add(code);
			System.out.println(code.getTime() + "/t" + code.getStr());
		}
	}

	private long strToLong(String timeStr) {
		String[] s = timeStr.split(":");
		int min = Integer.parseInt(s[0]);
		String[] ss = s[1].split("//.");
		int sec = Integer.parseInt(ss[0]);
		int mill = Integer.parseInt(ss[1]);
		return min * 60 * 1000 + sec * 1000 + mill * 10;
	}

	public void readMp3(String song) {
		
		// Place only once ,next click will return
		if(palyedBoolean)return;
		palyedBoolean = true;
		
		System.out.println("----------play music----------");
		String path = song ; 
		if(path == null) {
			path = "C://Users//eyuuyee//Music//0541.mp3";
			
			//TODO  add method that can get path from play list 
			
			file = new File(path);
		}		
			try {
				fis = new FileInputStream(file);
				PlayMp3(fis);
			} catch (FileNotFoundException e) {
			}
	


	}
	
	
	public void PlayMp3( FileInputStream fis){
		
				
		try {
		
			BIS = new BufferedInputStream(fis);
			player = new Player(BIS);
			
			songLength = fis.available();
			}catch (JavaLayerException | IOException e ) {
			}
		
		
			new Thread() {

				@Override
				public void run() {
					try {
						player.play();
					} catch (JavaLayerException e) {
					}
				}
					
			}.start();
		
	}
	
	public void stopMp3() {
		
		if(player != null){
			player.close();
			pausePosition = 0;
			songLength = 0;
		}
	}
	
	public void PauseMp3() {
		
		if(player != null){
			try {
				
				pausePosition = fis.available();
				player.close();
			
			} catch (IOException e) {
			}
			
		}
	}
	
	
public void ResumeMp3() {
			
			try {
				fis = new FileInputStream(file);
				fis.skip(songLength - pausePosition);
				PlayMp3(fis);
			} catch (Exception e) {
			}
				

	}
	

	public long UpdateSongPosition(){
		if(player == null) return 0;
			
		try {
			pausePosition = fis.available();
		} catch (IOException e) {
		}
		return pausePosition;
	}
	
	public void playMp3Anywhere(int pausePrecent) {
		
		if(!palyedBoolean) return;
		
		if(player != null){
			player.close();
		}

		try {
			fis = new FileInputStream(file);
			fis.skip(pausePrecent);
			pausePosition = fis.available();
		
		} catch ( IOException e ) {
		}

			PlayMp3(fis);
	}
	
	
	public void ChooseMP3() {
		FileFilter filter = new FileNameExtensionFilter("MP3 Files","mp3","mpeg3");
		JFileChooser chooser =new JFileChooser("C://Users//eyuuyee//Music");
		chooser.addChoosableFileFilter(filter);
		
		int returnVal = chooser.showOpenDialog(null) ;
		
		if(returnVal == JFileChooser.APPROVE_OPTION ){
			File myFile = chooser.getSelectedFile();
			String song = myFile +"";
			songName = chooser.getSelectedFile().getName();
			
			this.readMp3(song);
			
		}
	}

	public long getSongLength() {
		return songLength;
	}
	
	
/*
	public static void main(String[] args) {

		mp3Demo playLrc = new mp3Demo();
		playLrc.readFile();
	//	playLrc.readMp3();
		
	}
*/
	class Code {

		private long time;
		private String str;

		public Code(long time, String str) {
			setTime(time);
			setStr(str);
		}

		public long getTime() {
			return time;
		}

		public void setTime(long time) {
			this.time = time;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

	}

}
