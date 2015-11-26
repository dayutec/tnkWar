package tankWar;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tankClinet extends Frame {

	
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(50, 50, 30, 30);
		g.setColor(c);
	}
	
	
	public void lauchFrame(){
		this.setLocation(400,300);
		this.setSize(800, 600);
		this.setTitle("TankWar");
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		
		this.setResizable(false);
		this.setBackground(Color.GRAY);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tankClinet tc = new tankClinet();
		tc.lauchFrame();
	}

}
