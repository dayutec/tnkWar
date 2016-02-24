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
	
	public FileInputStream fis;
	public BufferedInputStream BIS;
	public SourceDataLine dataLine;
	public AudioFormat fileFormat;
	public ArrayList<Code> lrc = new ArrayList<Code>();
	
	public Player player;
	private long pausePosition;
	private long songLength;
	
	
	public String songName;
	
	public void readFile() {
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
		System.out.println("----------play music----------");
		String path = song ; 
		if(path == null) path = "C://Users//eyuuyee//Music//0541.mp3";
		
		File file = new File(path);
		try {
			fis = new FileInputStream(file);
			
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
		
		File file = new File("C://Users//eyuuyee//Music//0541.mp3");
		try {
			fis = new FileInputStream(file);
			fis.skip(songLength - pausePosition);
			BIS = new BufferedInputStream(fis);
			player = new Player(BIS);
			
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
	

	public long UpdateSonePosition(){

		long pos = 0;
		try {
		
		  pos =  fis.available();
		} catch (IOException e) {
			
		};
		return pos;
	}
	
	public void platMp3Anywhere(double pausePrecent) {
		
		if(player != null){
			player.close();
		}
		
		File file = new File("C://Users//eyuuyee//Music//0541.mp3");
		try {
			fis = new FileInputStream(file);
			songLength = fis.available();
			pausePosition = (long)(songLength * (pausePrecent)) ;
			fis.skip(pausePosition);
			BIS = new BufferedInputStream(fis);
			player = new Player(BIS);
			
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
	
	public void parseLine(String line) {
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String time = matcher.group();
			String str = line.substring(line.indexOf(time) + time.length() + 1);
			Code code = new Code(strToLong(time), str);
			lrc.add(code);
			// System.out.println(code.getTime() + "/t" + code.getStr());
		}
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
