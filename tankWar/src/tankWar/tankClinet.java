package tankWar;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class tankClinet extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final int WIN_SIZE_WIDTH =800;
	public static final int WIN_SIZE_HEIGHT =600;
	//int tank_x=50, tank_y=50;
	
	Tank myTank = new Tank(50,50,this);
	Bullet b = null;
	Image offScreenImage = null;


	public void paint(Graphics g){
	//	Color c = g.getColor();
	//	g.setColor(Color.RED);
	//  g.fillOval(tank_x, tank_y, 30, 30);
	//	g.setColor(c);
	
	//  tank_y += 5; //tanks_y
	
		myTank.draw(g);
		if(b!=null)	b.draw(g);
		
	}
	
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
		if(offScreenImage == null){
			offScreenImage = this.createImage(WIN_SIZE_WIDTH,WIN_SIZE_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GRAY);
		gOffScreen.fillRect(0, 0, WIN_SIZE_WIDTH, WIN_SIZE_HEIGHT);
		gOffScreen.setColor(c);
		
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0,null);
		
	}
	
	
	public void lauchFrame(){
		this.setLocation(200,50);
		this.setSize(WIN_SIZE_WIDTH, WIN_SIZE_HEIGHT);
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
		this.addKeyListener(new KeyMonitor());
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
	
	private class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
		//	System.out.println("ok");
			myTank.keypress(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
			myTank.keyRelease(e);
		}
		
	}

}
