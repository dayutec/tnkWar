package tankWar;

import java.awt.Color;
import java.awt.Graphics;

public class Explode {
	int x,y;
	private  boolean live =true;
	
	int[] diameter ={4,7,12,18,32,32,30,14,6};
	
	int step=0;
	
	private tankClinet tc;
	
	public Explode(int x,int y,tankClinet tc){
		this.x=x;
		this.y=y;
		this.tc =tc;
	}
	
	
	public void draw(Graphics g){
		if(!live){
		tc.explodes.remove(this);	
		return;
		}
		
		if(step == diameter.length){
			live =false;
			step=0;
			
		}
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, diameter[step], diameter[step]);
		g.setColor(c);
		step ++;
	}
}
