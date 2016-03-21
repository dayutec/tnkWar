package com.smalf.aControl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.tritonus.share.sampled.TAudioFormat;
import org.tritonus.share.sampled.file.TAudioFileFormat;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
/*
public class test {
	
	public void init(){
		String bip = "C://Users//eyuuyee//Music//0541.mp3";
    	Media hit = new Media(bip);
    	MediaPlayer mediaPlayer = new MediaPlayer(hit);
    	mediaPlayer.play();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    Media pick = new Media("0541.mp3"); //throws here
        MediaPlayer player = new MediaPlayer(pick);
        player.play();
		
	}

}*/
import javafx.stage.Stage;


public class test extends Application{

    @Override
    public void start(Stage primaryStage)
    {
        //Add a scene
        Group root = new Group();
        Scene scene = new Scene(root, 500, 200);

        Media pick = new Media("C://Users//eyuuyee//Music//0541.mp3");
        MediaPlayer player = new MediaPlayer(pick);
        player.play();

        //Add a mediaView, to display the media. Its necessary !
        //This mediaView is added to a Pane
        MediaView mediaView = new MediaView(player);
        ((Group)scene.getRoot()).getChildren().add(mediaView);

        //show the stage
        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void testJar(){
    	MP3File file;
		//try {
		//	file = new MP3File("C://Users//eyuuyee//Music//0541.mp3");
		
			int duration = 0;

			try {
			  AudioFile audioFile = AudioFileIO.read(new File("C://Users//eyuuyee//Music//0541.mp3"));
			  duration = audioFile.getAudioHeader().getTrackLength();
			  System.out.println("time = " + duration);

			} catch (Exception e) {
			  e.printStackTrace();

			}
    }
    

    
    
    
    public void sd() throws UnsupportedAudioFileException, IOException{
    	File file = null;  
    	file = new File("C://Users//eyuuyee//Music//0541.mp3");
    	 AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
    	    if (fileFormat instanceof TAudioFileFormat) {
    	        Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
    	        String key = "duration";
    	        Long microseconds = (Long) properties.get(key);
    	        int mili = (int) (microseconds / 1000);
    	        int sec = (mili / 1000) % 60;
    	        int min = (mili / 1000) / 60;
    	        System.out.println("time = " + min + ":" + sec);
    	    } else {
    	        throw new UnsupportedAudioFileException();
    	    }
    }
    
    
    
    public void ssd() throws UnsupportedAudioFileException, IOException{
    	
    	
    //	Player player = new Player();
    	File file = new File("C://Users//eyuuyee//Music//0541.mp3");
    	AudioFileFormat baseFileFormat = null;
    	AudioFormat baseFormat = null;
    	baseFileFormat = AudioSystem.getAudioFileFormat(file);
    	baseFormat = baseFileFormat.getFormat();
    	// TAudioFileFormat properties
    	if (baseFileFormat instanceof TAudioFileFormat)
    	{
    	    Map properties = ((TAudioFileFormat)baseFileFormat).properties();
    	    String key = "author";
    	    String val = (String) properties.get(key);
    	    key = "mp3.id3tag.v2";
    	    InputStream tag= (InputStream) properties.get(key);
    	    System.out.println("time = " + val);
    	}
    	// TAudioFormat properties
    	if (baseFormat instanceof TAudioFormat)
    	{
    	     Map properties = ((TAudioFormat)baseFormat).properties();
    	     String key = "bitrate";
    	     Integer val = (Integer) properties.get(key);
    	    	
    	     
    	     System.out.println("time = " + val);
    	     
    	     String keys = "album ";
    	     String vals = (String) properties.get(keys);
    	     System.out.println("time = " + vals);
    	}
    	

    	
    }
    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
         //launch(args);
         new test().testJar();
         Time rt = new Time(00, 2, 3);
         System.out.println("time = " + rt + "to int " + (rt.getMinutes()*60+ rt.getSeconds()) );
         int l=185;
         int hh=l/3600;
		 int mm=l/60;
		 int ss=l%60;
		 System.out.println(hh+":"+mm+":"+ss);
    }

}