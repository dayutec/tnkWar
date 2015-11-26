package tankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Tank {
	int loc_x,loc_y;

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
	}
	
	public void keypress(KeyEvent e){
		int key = e.getKeyCode();
		switch (key){
			case KeyEvent.VK_RIGHT : loc_x+=50; break;
			case KeyEvent.VK_LEFT  : loc_x-=50; break;
			case KeyEvent.VK_UP    : loc_y-=50; break;
			case KeyEvent.VK_DOWN  : loc_y+=50; break;
			
			default :break;
		}
	} 
	
}
