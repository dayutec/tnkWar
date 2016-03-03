package lrc;





import java.io.File;

import javax.media.Manager;
import javax.media.Player;
/**
 * @author naveen.k
 */
public class AudioPlay {
    static Player audioPlayer = null;
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        try {
            Manager.createRealizedPlayer(new File("C://Users//eyuuyee//Music//0541.mp3").toURL()).start();
        } catch (Exception ex) { ex.printStackTrace();  }
    }
}