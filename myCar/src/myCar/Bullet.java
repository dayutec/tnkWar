package myCar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import myCar.myTanks.Direction;

public class Bullet {
	
	
	
	public static int BULLET_SIZE = 10;
	public static int bulletSpeed = 16;
	public static int TANK_CENTER =10;
	public static int gunLength =24;

	private  mainFrame mF;
//	private Graphics g;
//	enum Direction{NORTH,SOUTH,EAST,WEST,T};
	
	private int x,y;
	private Direction dirBullet=Direction.T;
	private boolean isLive=true;
	
	
	


	private boolean isAllian=true;
	
	
	
	public Bullet(boolean b) {
		// TODO Auto-generated constructor stub
		this.isAllian = b;
	}

	public void setLocation(int x, int y, Direction dir, mainFrame mF) {
		// TODO Auto-generated method stub
		this.x=x+TANK_CENTER;
		this.y=y+TANK_CENTER;
		this.dirBullet= dir;
		this.mF=mF;
		
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(!isLive ){
			mF.bullets.remove(this);
			return;
		}
				
		if(x>0 & y>0 & x< 800 & y < 600){
		
			Color c = new Color(220,220,220);
			g.setColor(c);	
		
				switch(dirBullet){
				case EAST:  
						    g.fillOval(x+gunLength, y, BULLET_SIZE , BULLET_SIZE); //fire from gun eage.
						    x += bulletSpeed ;
						    break;
				case SOUTH: 
							g.fillOval(x, y+gunLength, BULLET_SIZE , BULLET_SIZE);
							y += bulletSpeed ;
							break;
				case WEST:  
							g.fillOval(x-gunLength, y, BULLET_SIZE , BULLET_SIZE);
							x -= bulletSpeed ;
							break;
				case NORTH: 
							g.fillOval(x, y-gunLength, BULLET_SIZE , BULLET_SIZE);
							y -= bulletSpeed ;
							break;
				default: break;
			}
		}else{
			isLive = false;
			mF.bullets.remove(this);
			
		}
		

	}
	
	
	public Rectangle getRect(){
		return new Rectangle(x, y, BULLET_SIZE, BULLET_SIZE);
	}

	public boolean isAllian() {
		return isAllian;
	}

	public void setAllian(boolean isAllian) {
		this.isAllian = isAllian;
	}
	
	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	
	

	



	

}
