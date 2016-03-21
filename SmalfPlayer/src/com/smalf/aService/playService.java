package com.smalf.aService;


import java.io.File;
import java.sql.Time;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;








public class playService {
	
	public static String FilePath = "C://Users//eyuuyee//Music//0541.mp3";

	BasicPlayer Bplayer; 
	File file = new File(FilePath);

	private int songTotalByteLength;
	private int fisAvaliable;
	

	public int getSongTotalTime(){
		int duration = 0;

		try {
		  AudioFile audioFile = AudioFileIO.read(new File("C://Users//eyuuyee//Music//0541.mp3"));
		  duration = audioFile.getAudioHeader().getTrackLength();
		  System.out.println("time = " + duration);

		} catch (Exception e) {
		  e.printStackTrace();

		}
		
		return duration;
	}

	public int getM_status() {
		return Bplayer.getStatus();
	}

	public playService(){
		
		Bplayer= new BasicPlayer();
		
	}
	
	public int getFISPosition(){
		if (Bplayer == null) return 0;
		fisAvaliable = Bplayer.getEncodedStreamPosition();
		return fisAvaliable;
	}
	
	public int getFISEnd(){
		if (Bplayer == null) return 0;
		songTotalByteLength = Bplayer.getEncodedLength();
		return songTotalByteLength;
	}
	
	
	public void playAudio(String song) {
		
		System.out.println("----------play music----------");
		String path = song ; 
		if(path == null) {
			path = "C://Users//eyuuyee//Music//0541.mp3";
			file = new File(path);
		}
		try {
			Bplayer.open(file);
			Bplayer.play();
			
		} catch (BasicPlayerException e) {

			e.printStackTrace();
		}
		
		
	}
	
	
	public void pauseAudio() {
			
			if(Bplayer != null){
				System.out.println("----------pause music----------");
				try {
					Bplayer.pause();
				
				} catch (BasicPlayerException e) {

				}
				
			}
		}
	
	
	public synchronized void resumeAudio() {
		
		if(Bplayer != null){
			try {
				
				Bplayer.resume();
			
			} catch ( BasicPlayerException e) {
			}
			
		}
	}
	
	public synchronized void stopAudio() {
		
		if(Bplayer != null){
			try {
				
				Bplayer.stop();
		
			} catch ( BasicPlayerException e) {
			}
			
		}
	}

	
	
	public void seekAudio(double precent) {
		
		
		if(Bplayer != null){
			
			
			long bytes =  (long) (precent * songTotalByteLength);	
			try {
				Bplayer.seek(bytes);
			
			} catch (BasicPlayerException e) {}
			}
	}
	
	public void seekAudio(int precent) {
			
			
		    System.out.println(precent);
		
			if(Bplayer != null){
				
				
				long bytes =  (long) (precent * songTotalByteLength);	
				try {
					Bplayer.seek(bytes);
				
				} catch (BasicPlayerException e) {}
				}
		}
	
	
	
}
	
	
	
	




