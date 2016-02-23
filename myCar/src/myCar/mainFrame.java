package myCar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;



public class mainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	
	myTanks tank_good; 
	myTanks enemy_Tank;
	
	private boolean enemyMark=true;
	
	Bullet b;
	List<Bullet> bullets = new ArrayList<Bullet>();
	List<myTanks> enemyTanks = new ArrayList<myTanks>();
	
	mainFrame mF ;
	
	//private JPanel jBackGround= new JPanel() ;

	Image image ;//= createImage(WIDTH, HEIGHT);
	
	
	public mainFrame(){
		
		setTitle("TankWar");
		setSize(WIDTH, HEIGHT);
	//	setBackground(Color.DARK_GRAY);
		Color c = new Color(140, 200, 120);
		setBackground(c);
		
		setResizable(false);

	//	tank_good = new myTanks(this);
		tank_good = new myTanks(50,500,this,!enemyMark);
		
		if(enemyTanks.size()<=0) initEnemyTanks();
		
		
		this.addKeyListener(new keyMonitor());
		
		new Thread( new PaintThread()).start();
	}
	
	
	private void initEnemyTanks(){
		int x= 60,y=20;
		for(int i =1 ; i< 5;i++){
			enemy_Tank = new myTanks(x*i,y,this,enemyMark);
			enemyTanks.add(enemy_Tank);
		}
		
	}
	
	public void paint(Graphics g){
		
	//	Logger.getGlobal().info("hello");
	//	System.out.println("xx");
/*
		g.setColor(getBackground());
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLUE);
		g.drawString("bullets acount " +bullets.size(), 100, 100);
		tank_good.draw(g);
		
	//	if(b!=null)b.draw(g);
		
		for(int i =0 ; i< bullets.size();i++){
			b=bullets.get(i);
			b.draw(g);
		}
	*/	
		
		//buffer for screen, crease blink
		if( image == null) image = this.createImage(WIDTH, HEIGHT);
		Graphics g2=image.getGraphics();
		Color c = new Color(140, 200, 120);
		g2.setColor(c);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
		g2.setColor(Color.BLUE);
		g2.drawString("Bullets acount " +bullets.size(), 100, 100);
		
		// draw  Tanks & Bullets & Wall
		tank_good.draw(g2);
		
		for(int i =0 ; i< enemyTanks.size();i++){
			enemy_Tank=enemyTanks.get(i);
			enemy_Tank.draw(g2);
		}
		for(int i =0 ; i< bullets.size();i++){
			b=bullets.get(i);
			b.draw(g2);
		}
		
		g.drawImage(image, 0, 0, null);
	
			
	}

	

	private class keyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			tank_good.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyReleased(e);
			tank_good.keyReleased(e);
		}
		
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
