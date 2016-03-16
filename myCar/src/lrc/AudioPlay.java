package lrc;



import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;




/**
 * @author naveen.k
 */
public class AudioPlay {
		
	public void init(){
		String bip = "C://Users//eyuuyee//Music//0541.mp3";
    	Media hit = new Media(bip);
    	MediaPlayer mediaPlayer = new MediaPlayer(hit);
    	mediaPlayer.play();
	}

	public static void main(String[] args) {

		new AudioPlay().init();
		
		System.out.println("ssdf");
       
    }
}