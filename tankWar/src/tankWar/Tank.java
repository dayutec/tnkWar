package tankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {
	
	public static final int XSPEED=5;
	public static final int YSPEED=5;
	
	private int loc_x,loc_y;
	private boolean bL= false ,bU =false, bD= false, bR=false;
	
	private enum Direction{L,LU,U,RU,R,RD,D,LD,S};
	private Direction dir = Direction.S;

	public Tank(int loc_x, int loc_y) {
		super();
		this.loc_x = loc_x;
		this.loc_y = loc_y;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(loc_x, loc_y, 30, 30);
		g.setColor(c);
		
		move();
	}
	
	
	public void move(){
		switch (dir){
		case L: loc_x-=XSPEED; break;
		case LU:loc_x-=XSPEED; loc_y-=YSPEED;break;
		case U: loc_y-=YSPEED;break;
		case RU:loc_x+=XSPEED; loc_y-=YSPEED;break;
		case R: loc_x+=XSPEED; break;
		case RD:loc_x+=XSPEED; loc_y+=YSPEED;break;	
		case D: loc_y+=YSPEED;break;
		case LD:loc_x-=XSPEED; loc_y+=YSPEED;break;
		case S: break;
			default : break;
		}
	}
	
	public void keypress(KeyEvent e){
		int key = e.getKeyCode();
		switch (key){
			case KeyEvent.VK_RIGHT : bR = true; break;
			case KeyEvent.VK_LEFT  : bL = true; break;
			case KeyEvent.VK_UP    : bU = true; break;
			case KeyEvent.VK_DOWN  : bD = true; break;
			
			default :break;
		}
		
		locateDirection();
	} 
	

	public void keyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch (key){
			case KeyEvent.VK_RIGHT : bR = false; break;
			case KeyEvent.VK_LEFT  : bL = false; break;
			case KeyEvent.VK_UP    : bU = false; break;
			case KeyEvent.VK_DOWN  : bD = false; break;
			default :break;
		}
		
		locateDirection();
	}
	
	void locateDirection(){
		if(bL && !bU && !bR && !bD) dir = Direction.L ;
		else if( bL &&  bU && !bR && !bD) dir = Direction.LU ;
		else if(!bL && bU && !bR && !bD)  dir = Direction.U ;
		else if(!bL && bU && bR && !bD)   dir = Direction.RU ;
		else if(!bL && !bU && bR && !bD)  dir = Direction.R ;
		else if(!bL && !bU && bR && bD)   dir = Direction.RD ;
		else if(!bL && !bU && !bR && bD)  dir = Direction.D ;
		else if( bL && !bU && !bR && bD)  dir = Direction.LD ;
		else if(!bL && !bU && !bR && !bD) dir = Direction.S ;
		
	}
	
}
