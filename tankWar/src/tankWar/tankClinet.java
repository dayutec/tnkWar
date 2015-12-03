package tankWar;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;

public class tankClinet extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final int WIN_SIZE_WIDTH =800;
	public static final int WIN_SIZE_HEIGHT =600;
	
	public static final boolean FriendTank =false;
	public static final boolean EnemyTank =true;
	//int tank_x=50, tank_y=50;
	
	Tank myTank = new Tank(50,50,FriendTank ,Tank.Direction.S,this);
//	Tank antiTank = new Tank(100,50,EnemyTank ,this);
	
//	Explode e = new Explode(100,100,this);
//	Bullet b = null;
	
	List<Tank> antiTanks  = new ArrayList<Tank>();
	
	List<Explode> explodes  = new ArrayList<Explode>();
	List<Bullet> bullets  = new ArrayList<Bullet>();
	
	Image offScreenImage = null;


	public void paint(Graphics g){
	//	Color c = g.getColor();
	//	g.setColor(Color.RED);
	//  g.fillOval(tank_x, tank_y, 30, 30);
	//	g.setColor(c);
	
	//  tank_y += 5; //tanks_y
		
		g.drawString("bullets acount " +bullets.size(), 60, 60);
		g.drawString("antiTanks acount " +antiTanks.size(), 60, 80);
		
	//	if(b!=null)	b.draw(g);
		
		for(int i=0; i< bullets.size() ;i++){
			Bullet b = bullets.get(i);
			b.hitTanks(antiTanks);
			b.hitTank(myTank);
			b.draw(g);
		}
		
		for(int i=0; i< explodes.size() ;i++){
			Explode e = explodes.get(i);
			
			e.draw(g);
		}
		
		myTank.draw(g);
		
		for(int i=0; i< antiTanks.size() ;i++){
			Tank antiTank = antiTanks.get(i);
			antiTank.draw(g);
		}
		
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
	
	
	public void initAntiTank(){
		
		for(int i=2; i<=10;i++){
			antiTanks.add(new Tank(i*50,50,EnemyTank,Tank.Direction.D ,this));
		}
		
	}
	
	public void lauchFrame(){
		this.initAntiTank();
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
