package tankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {
	
	public static final int XSPEED=5;
	public static final int YSPEED=5;
	
	public static final int WIDTH=30;
	public static final int HEIGHT=30;
	
	tankClinet tc =null;
	private int loc_x,loc_y;

	
	private boolean bL= false ,bU =false, bD= false, bR=false;

	
	enum Direction{L,LU,U,RU,R,RD,D,LD,S};
	private Direction dir = Direction.S;

	public Tank(int loc_x, int loc_y) {
		super();
		this.loc_x = loc_x;
		this.loc_y = loc_y;
		
	}
	

	public Tank(int loc_x, int loc_y, tankClinet tc) {
		
		this(loc_x,loc_y);
		this.tc =tc;
		
	}
	
	
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(loc_x, loc_y, WIDTH, HEIGHT);
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
			case KeyEvent.VK_SPACE : tc.b=fire();break; 
			default :break;
		}
		
		locateDirection();
	} 
	

	private Bullet fire() {
		
		int loc_x= this.loc_x + WIDTH/2 - Bullet.WIDTH;
		int loc_y= this.loc_y + HEIGHT/2 - Bullet.HEIGHT;
		
		Bullet b = new Bullet(loc_x,loc_y,dir);
		return b;
	}

	public void keyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch (key){
			case KeyEvent.VK_RIGHT : bR = false; break;
			case KeyEvent.VK_LEFT  : bL = false; break;
			case KeyEvent.VK_UP    : bU = false; break;
			case KeyEvent.VK_DOWN  : bD = false; break;
	//		case KeyEvent.VK_SPACE : bFire = false;break;
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
