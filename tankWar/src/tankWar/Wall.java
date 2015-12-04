package tankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall {
	
	private static final int REC_HEIGHT = 200;
	private static final int REC_WIDTH = 20;
	private static final int REC_X = 200;
	private static final int REC_Y = 60;
	
	private tankClinet tc;
	
		
	public Wall(tankClinet tc) {
		super();
		this.tc = tc;
	}





	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.CYAN);
		g.fillRect(REC_X,REC_Y, REC_WIDTH,REC_HEIGHT);
		g.setColor(c);
	}
	
	
	public Rectangle getRect(){
		return new Rectangle(REC_X,REC_Y, REC_WIDTH,REC_HEIGHT);
	}
	

}
