package tankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Tank {
	
	public static final int XSPEED=5;
	public static final int YSPEED=5;
	
	public static final int WIDTH=30;
	public static final int HEIGHT=30;
	
	tankClinet tc =null;
	
	private boolean tLive =true;
	
	
	public boolean istLive() {
		return tLive;
	}
	
	public void settLive(boolean tLive) {
		this.tLive = tLive;
	}


	private boolean enemyTank =false;
	
	private int loc_x,loc_y;

	
	private boolean bL= false ,bU =false, bD= false, bR=false;

	
	enum Direction{L,LU,U,RU,R,RD,D,LD,S};
	private Direction dir = Direction.S;
	private Direction gunDir = Direction.R;
	

	public Tank(int loc_x, int loc_y, boolean eT) {
		super();
		this.loc_x = loc_x;
		this.loc_y = loc_y;
		this.enemyTank =eT;
		
	}
	

	public Tank(int loc_x, int loc_y, boolean eT, tankClinet tc) {
		
		this(loc_x,loc_y,eT);
		this.tc =tc;
		
	}
	
	
	
	public void draw(Graphics g){
		if(!tLive) return;
		
		Color c = g.getColor();
		if(enemyTank)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.RED);
		g.fillOval(loc_x, loc_y, WIDTH, HEIGHT);
		g.setColor(c);
		
		gunMove(g);
		move();
		
	}
	



	public void gunMove(Graphics g){
		
		int x =Tank.WIDTH/2;
		int y =Tank.HEIGHT/2;
		int xEx=16;
		int yEx=16;
		
		int cent_x= loc_x+x;
		int cent_y= loc_y+y;
		
	//	coordinate c =  new coordinate();s
		
		switch (gunDir){
		case L: 	
			g.drawLine(cent_x, cent_y, cent_x-xEx, cent_y);
			break;
		case LU:
			g.drawLine(cent_x, cent_y, cent_x-xEx, cent_y-yEx);
			break;
		case U: 
			g.drawLine(cent_x, cent_y, cent_x, cent_y-yEx);
			break;
		case RU:
			g.drawLine(cent_x, cent_y, cent_x+xEx, cent_y-yEx);
			break;
		case R: 
			g.drawLine(cent_x, cent_y, cent_x+xEx, cent_y);
			break;
		case RD:
			g.drawLine(cent_x, cent_y, cent_x+xEx, cent_y+yEx);
			break;	
		case D: 
			g.drawLine(cent_x, cent_y, cent_x, cent_y+yEx);
			break;
		case LD:
			g.drawLine(cent_x, cent_y, cent_x-xEx, cent_y+yEx);
			break;
		case S: 
			break;
		default : break;
		}
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
		
		if(this.dir!= Direction.S){
			this.gunDir = dir;
		}
		
		
		if(loc_x <0) loc_x=0;
		if(loc_y <30) loc_y= 30;
		if(loc_x + Tank.WIDTH > tankClinet.WIN_SIZE_WIDTH) loc_x = tankClinet.WIN_SIZE_WIDTH -Tank.WIDTH;
		if(loc_y + Tank.HEIGHT> tankClinet.WIN_SIZE_HEIGHT) loc_y = tankClinet.WIN_SIZE_HEIGHT -Tank.HEIGHT;
		
	}
	
	public void keypress(KeyEvent e){
		int key = e.getKeyCode();
		switch (key){
			case KeyEvent.VK_RIGHT : bR = true; break;
			case KeyEvent.VK_LEFT  : bL = true; break;
			case KeyEvent.VK_UP    : bU = true; break;
			case KeyEvent.VK_DOWN  : bD = true; break;
			//case KeyEvent.VK_SPACE : tc.b=fire();break; 
		//	case KeyEvent.VK_SPACE : fire();break; 
			default :break;
		}
		
		locateDirection();
	} 
	

	private Bullet fire() {
		
		int loc_x= this.loc_x + WIDTH/2 - Bullet.WIDTH;
		int loc_y= this.loc_y + HEIGHT/2 - Bullet.HEIGHT;
		
		Bullet b = new Bullet(loc_x,loc_y,gunDir,this.tc);
		tc.bullets.add(b);
		
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
			case KeyEvent.VK_SPACE : fire() ;break;
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
	
	
	public Rectangle getRect(){
		
		return new Rectangle(loc_x, loc_y, WIDTH, HEIGHT);
	}
	
}
