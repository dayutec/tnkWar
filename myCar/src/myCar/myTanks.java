package myCar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;


public class myTanks {
	
	public static final int TANK_WIDTH=30;
	public static final int TANK_HEIGHT=30;
	private static final int XSPEED = 10;
	private static final int YSPEED = 10;
	private static final int MAX_HEIGHT = 400;
	private static final int MAX_WIDHT = 600;
	private int x=50;
	private int y=50;
	
	mainFrame mF ;
	//Graphics g ;
	private boolean keyR,keyL,keyU,keyD;
	
	enum Direction{NORTH,SOUTH,EAST,WEST,T};
	private Direction dir = Direction.T;
	private Direction gunDir = Direction.EAST;
	
	private boolean friendMark ;
	private boolean initEnemyTank=true;
	private boolean isLive=true;
	private static Random r;
	private int step =12;
	private int beforMoving_x;
	private int beforMoving_y;
	
	
	public  myTanks(mainFrame mF){
			this.mF =mF; 		
	}
	
	/*
	public myTanks(mainFrame mF, boolean enemyMark) {
		// TODO Auto-generated constructor stub
		this.mF =mF; 	
		this.friendMark = !enemyMark;
	}
*/

	public myTanks(int x, int y, mainFrame mF, boolean enemyMark) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.mF =mF; 	
		this.friendMark = !enemyMark;
	}


	public void draw(Graphics g){
		
		if(!isLive){
			if(!friendMark)mF.enemyTanks.remove(this);
			return;
		}
		
		drawTank(g);
		
		enemyAI();
		move();
	}
	
	public void drawTank(Graphics g){
		
		Color c = new Color(225, 0, 130);
		
		if(!friendMark){
			c = new Color(127, 127, 127);
			
		}
			
		g.setColor(c);
		g.fill3DRect(x, y, TANK_WIDTH, TANK_HEIGHT,true);
		
		drawTankGun(g);
	}
	
	public void drawTankGun(Graphics g){
		
		Color c = new Color(160, 0, 180);
		g.setColor(c);
		
		int gunPlant =12;
		
		int gunLength=24;
		int gunWidth =6;
		
		g.fillRect(x + TANK_WIDTH/2-gunPlant/2, y+ TANK_HEIGHT/2-gunPlant/2, gunPlant, gunPlant);
		
		if(initEnemyTank){
			gunDir=Direction.SOUTH;
			initEnemyTank =false;
		}
		
		switch (gunDir){
		case EAST:
				g.fillRect(x + TANK_WIDTH/2, y+ TANK_HEIGHT/2-gunWidth/2, gunLength, gunWidth);
				break;
		case SOUTH:
				g.fillRect(x + TANK_WIDTH/2-gunWidth/2, y+ TANK_HEIGHT/2, gunWidth, gunLength);
				break;
		case WEST:
				g.fillRect(x + TANK_WIDTH/2-gunLength, y+ TANK_HEIGHT/2-gunWidth/2, gunLength, gunWidth);
				break;
		case NORTH:
				g.fillRect(x + TANK_WIDTH/2-gunWidth/2, y+ TANK_HEIGHT/2-gunLength, gunWidth,gunLength );
				break;
		case T:
				break;
		default: 
				break;
		}
	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		switch (key){
			case KeyEvent.VK_RIGHT : keyR = true; break;
			case KeyEvent.VK_LEFT  : keyL = true; break;
			case KeyEvent.VK_UP    : keyU = true; break;
			case KeyEvent.VK_DOWN  : keyD = true; break;
			case KeyEvent.VK_SPACE : fire() ;break;
			case KeyEvent.VK_A : superFire() ;break;
			default :break;
		}
		
		reDirection();
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		switch (key){
			case KeyEvent.VK_RIGHT : keyR = false; break;
			case KeyEvent.VK_LEFT  : keyL = false; break;
			case KeyEvent.VK_UP    : keyU = false; break;
			case KeyEvent.VK_DOWN  : keyD = false; break;
		//	case KeyEvent.VK_SPACE : fire() ;break;
		//	case KeyEvent.VK_A : superFire() ;break;
			default :break;
		}
		reDirection();
	}


	private void reDirection() {
		// TODO Auto-generated method stub
	    if(keyR) dir=Direction.EAST;
		else if(keyL) dir=Direction.WEST;
		else if(keyU) dir=Direction.NORTH;
		else if(keyD) dir=Direction.SOUTH;
		else dir=Direction.T;
	}



	private void move(){
				
		beforMoving_x = x;
		beforMoving_y = y;
		
		switch (dir){
		case SOUTH: y+=XSPEED; break;
		case NORTH: y-=XSPEED; break;
		case EAST:  x+=YSPEED; break;
		case WEST:  x-=YSPEED; break;
		case T: break;
		default : break;
		}
		
		if(this.dir!= Direction.T){
			gunDir = dir;
		}
		
		hitCheck();
		hitBullet();
		
		int southMargin =  MAX_HEIGHT -TANK_HEIGHT-4 ;
		int westMargin =4;
		int northMargin =TANK_HEIGHT-4;
		int eastMargin = MAX_WIDHT - TANK_WIDTH-4;
		if(y > southMargin) y=southMargin;
		if(y < northMargin) y=northMargin;
		if(x > eastMargin) x = eastMargin;
		if(x < westMargin) x = westMargin;
		
		
	}
	
	private void enemyAI(){
		if(!friendMark){
			
			Direction[] tempD = Direction.values();
		    
			r = new Random();
			if(step  == 0){
				step = r.nextInt(12)+3;
				
			    int rd = r.nextInt(tempD.length);
			    dir=tempD[rd];
			}
			
			step--;
			if(r.nextInt(100)>90)this.fire();
			
		}
	}

	private void superFire() {
		// TODO Auto-generated method stub
		
	}


	private void hitCheck(){
		
		for(int i= 0; i<mF.enemyTanks.size();i++){
			myTanks t = mF.enemyTanks.get(i);
			if(this!=t & this.getRect().intersects(t.getRect())  ){
				stay();
			}
			if(this.friendMark == false & this.getRect().intersects(mF.tank_good.getRect())){
				stay();
			}
		}
	}
	
	
	private void hitBullet(){
		
		for(int i= 0; i<mF.bullets.size();i++){
			Bullet b = mF.bullets.get(i);
	
			if( this.getRect().intersects(b.getRect())){
				if(b.isAllian() & this.friendMark){     ////Allian's tank and bullet
					//Do nothing
				}
				else if(!b.isAllian() & !this.friendMark )  //enemy's tank and bullet
				{
					//DO nothing
				}
				else{
					this.isLive=false;
					b.setLive(false);
				}
			}

		}
	}

	private void stay() {
		// TODO Auto-generated method stub
		x= beforMoving_x;
		y= beforMoving_y;
		
	}

	public Rectangle getRect(){
		return new Rectangle(x, y, TANK_WIDTH, TANK_HEIGHT);
	}

	private void fire() {
		// TODO Auto-generated method stub
		Bullet b = new Bullet(false);
		if(this.friendMark) b.setAllian(true);
		b.setLocation(x, y,gunDir,mF);
		mF.bullets.add(b);
		
	}
	
	
}
