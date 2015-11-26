package tankWar;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tankClinet extends Frame {

	int tank_x=50, tank_y=50;
	
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(tank_x, tank_y, 30, 30);
		g.setColor(c);
		
		tank_y += 5; //tanks_y
	}
	
	
	public void lauchFrame(){
		this.setLocation(200,50);
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
		
		new Thread( new PaintThread()).start();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tankClinet tc = new tankClinet();
		tc.lauchFrame();
		
	}
	
	
	private class PaintThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	

}