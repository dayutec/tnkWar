package tankWar;

import java.awt.Color;
import java.awt.Graphics;

import tankWar.Tank.Direction;

public class Bullet {

	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	public static final int WIDTH=5;
	public static final int HEIGHT=5;
	
	int bullit_x,bullit_y;
	Tank.Direction dir;
	
	
	
	
	public Bullet(int x, int y, Direction dir) {
		super();
		this.bullit_x = x;
		this.bullit_y = y;
		this.dir = dir;
	}
	
	public void draw(Graphics g){
		
		
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(bullit_x, bullit_y, WIDTH, HEIGHT);
		g.setColor(c);
		
		move();
	}
	
	
	public void move(){
		
		
		switch (dir){
		case L: bullit_x-=XSPEED; break;
		case LU:bullit_x-=XSPEED; bullit_y-=YSPEED;break;
		case U: bullit_y-=YSPEED;break;
		case RU:bullit_x+=XSPEED; bullit_y-=YSPEED;break;
		case R: bullit_x+=XSPEED; break;
		case RD:bullit_x+=XSPEED; bullit_y+=YSPEED;break;	
		case D: bullit_y+=YSPEED;break;
		case LD:bullit_x-=XSPEED; bullit_y+=YSPEED;break;
		case S: break;
			default : break;
		}
		
		
	   
}

	
}
