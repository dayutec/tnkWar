package tankWar;

import java.awt.Frame;

public class tankClinet extends Frame {

	
	public void lauchFrame(){
		this.setLocation(400,300);
		this.setSize(800, 600);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tankClinet tc = new tankClinet();
		tc.lauchFrame();
	}

}
