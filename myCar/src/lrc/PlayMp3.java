package lrc;

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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayMp3 {

	public final Pattern pattern = Pattern.compile("(?<=//[).*?(?=//])");
	public AudioInputStream inputStream;
	public SourceDataLine dataLine;
	public AudioFormat fileFormat;
	public ArrayList<Code> lrc = new ArrayList<Code>();

	public void readFile() {
		File file = new File("C://Users//eyuuyee//Music//233212.lrc");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					fis));
			String lrcString = null;
			
			 
			while ((lrcString = reader.readLine()) != null)
				parseLine(lrcString);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public void readMp3() {
		System.out.println("----------play music----------");
		File file = new File("C://Users//eyuuyee//Music//0541.mp3");
		try {
			inputStream = AudioSystem.getAudioInputStream(file);
			fileFormat = inputStream.getFormat();
			if (fileFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
				AudioFormat newFormat = new AudioFormat(
						AudioFormat.Encoding.PCM_SIGNED,
						fileFormat.getSampleRate(), 16,
						fileFormat.getChannels(), fileFormat.getChannels() * 2,
						fileFormat.getSampleRate(), false);
				System.out.println("Converting audio format to " + newFormat);
				AudioInputStream newStream = AudioSystem.getAudioInputStream(
						newFormat, inputStream);
				fileFormat = newFormat;
				inputStream = newStream;
			}

			DataLine.Info info = new DataLine.Info(SourceDataLine.class,
					fileFormat);
			dataLine = (SourceDataLine) AudioSystem.getLine(info);
			dataLine.open(fileFormat, dataLine.getBufferSize());
			dataLine.start();

			new Thread() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int index = 1;
					boolean mark = false;
					while (true) {
						long time = dataLine.getMicrosecondPosition() / 1000;
						if (time < lrc.get(index).getTime()) {
							if (!mark)
								System.out.println(lrc.get(index - 1).getStr());
							mark = true;
						} else {
							index++;
							mark = false;
						}
						try {
							sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}.start();

			int bufferSize = (int) fileFormat.getSampleRate()
					* fileFormat.getFrameSize();
			byte[] buffer = new byte[bufferSize];
			int bytesRead = 0;
			while (bytesRead >= 0) {
				bytesRead = inputStream.read(buffer, 0, buffer.length);
				if (bytesRead >= 0) {
					dataLine.write(buffer, 0, bytesRead);
				}
			}
		} catch (UnsupportedAudioFileException e) {

		} catch (IOException e) {

		} catch (LineUnavailableException e) {

		}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayMp3 playLrc = new PlayMp3();
		playLrc.readFile();
		playLrc.readMp3();
	}

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
