package com.smalf.aControl;

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
    public static void main(String[] args) {
         launch(args);
    }

}