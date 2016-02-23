package lrc;



import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;

import javax.swing.*;
import javax.media.*;

public class AudioPlay extends JFrame {
  public static void main(String args[]) throws Exception, MalformedURLException, IOException {
    Player player;

    File file = new File("C:/Users/eyuuyee/Music/0541.mp3");

    player = Manager.createPlayer(file.toURI().toURL());
//    player.addControllerListener(new EventHandler());
    player.start(); // start player
    
    player.close();

    Component visual = player.getVisualComponent();
    Component control = player.getControlPanelComponent();

  }
}

/*
import javax.media.*;

import java.net.*;
import java.io.*;
import java.util.*;


class AudioPlay
{
 public static void main(String[] args) throws Exception
 {
 
 
 // Take the path of the audio file from command line
// File f=new File(args[0]);
 System.out.println("ss");
 File f = new File("C:/Users/eyuuyee/Music/0541.mp3");
 // Create a Player object that realizes the audio
 final Player p=Manager.createRealizedPlayer(f.toURI().toURL());

 
  // Start the music
  p.start();

  System.out.println("e");
  // Create a Scanner object for taking input from cmd
  Scanner s=new Scanner(System.in);
  
  
  // Read a line and store it in st
  String st=s.nextLine();
  
  
   // If user types 's', stop the audio
   if(st.equals("s"))
   {
   p.stop();
   }
 }
}
*/