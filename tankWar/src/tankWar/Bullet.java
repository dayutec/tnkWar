package tankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import tankWar.Tank.Direction;

public class Bullet {

	
	public static final int XBase = 0;
	public static final int YBase = 0;
	
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	public static final int WIDTH=5;
	public static final int HEIGHT=5;
	
	
	int bullit_x,bullit_y;
	Tank.Direction dir;
	
	private  boolean enemyB =true;
	private  boolean myB =false;
	
	private boolean BulletLive = true;
	private tankClinet tc;
	
	
	public boolean isBulletLive() {
		return BulletLive;
	}

	public Bullet(int x, int y, Direction dir) {
		super();
		this.bullit_x = x;
		this.bullit_y = y;
		this.dir = dir;
	}
	
	public Bullet(int x, int y,boolean enemyB, Direction dir,tankClinet tc) {
		this(x,y,dir);
		this.tc = tc;
		this.setEnemyB(enemyB);
	}
	
	
	public void draw(Graphics g){
		
		
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(bullit_x, bullit_y, WIDTH, HEIGHT);
		g.setColor(c);
		
		move();
	}
	
	
	public void move(){
		if(!BulletLive){
			tc.bullets.remove(this);
			return;
		}
		
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
		
		if(bullit_x < XBase ||bullit_y < YBase || bullit_x > tankClinet.WIN_SIZE_WIDTH || bullit_y > tankClinet.WIN_SIZE_HEIGHT ){
			BulletLive =false ;
			tc.bullets.remove(this);
		}
		
	   
}

	
	public Rectangle getRect(){
		
		return new Rectangle(bullit_x, bullit_y, WIDTH, HEIGHT);
	}
	

	public boolean hitWall(Wall w){		
		if(this.isBulletLive() && this.getRect().intersects(w.getRect()) ){
			this.BulletLive=false;
				
			return true;
			}
		return false;
	}
	
	
	public boolean hitTank(Tank t){		
		if(this.isBulletLive() && this.getRect().intersects(t.getRect()) && t.istLive() && this.enemyB !=t.isEnemyTank()){
			
			if(t.isEnemyTank()){
				t.settLive(false);
			}
			else{
				t.setLife(t.getLife()-20);
				if(t.getLife()<=0)t.settLive(false);
			}
			
			
			this.BulletLive=false;
			
			Explode e = new Explode(bullit_x,bullit_y,tc);
			tc.explodes.add(e);
			
			return true;
			}
		return false;
	}
	
	
	
	public boolean hitTanks(List<Tank> tanks){
		
		for(int i=0;i<tanks.size();i++){
			if(hitTank(tanks.get(i))){
				return true;
			}
		}
		
		return false;
		
	}

	public boolean isEnemyB() {
		return enemyB;
	}

	public void setEnemyB(boolean enemyB) {
		this.enemyB = enemyB;
	}

	public boolean isMyB() {
		return myB;
	}

	public void setMyB(boolean myB) {
		this.myB = myB;
	} 
	
}
