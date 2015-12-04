package tankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blood {
	int x,y,w=15,b=15;
	tankClinet tc;
	int step =0;
	
	private boolean live =true;
	
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	private int[][] pos={
			{350,300},
			{360,300},
			{375,275},
			{400,200},
			{360,270},
			{365,290}
	};
	
	public Blood(){
		x=pos[0][0];
		y=pos[0][1];
	}
	
	public void draw(Graphics g){
		if(!live) return;
		
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
			
		g.fillRect(x, y-10, w, b);
		g.setColor(c);
		
		move();
	}

	private void move() {
		// TODO Auto-generated method stub
		step ++;
		
		if(step == pos.length) step=0;
		
		x=pos[step][0];
		y=pos[step][1];
		
	}
	
	public Rectangle getRect(){
		
		return new Rectangle(x, y, w, b);
	}
	
	
	
}
