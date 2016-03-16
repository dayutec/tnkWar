package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


public class textContentPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean coverText = true;

	private ArrayList<Point> pointlist = new ArrayList<Point>();


	Font sansbold14 = new Font("SanSerif",Font.BOLD,10);
	
	 public textContentPanel(){
			

		new Thread( new PaintThread()).start();

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g); //very important
		
				

		//set message String 
		g.setColor(Color.ORANGE);
		g.drawString("The quick brown fox jumps over a lazy dog",30,50);
		

		//use bufferImage to handles eraser effect 
		BufferedImage buffImg = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2I = buffImg.createGraphics();
		
		g2I.setColor(Color.BLUE);
		g2I.fillRect(30, 40, 200, 20);
		//set Clear ,refer to URL ->  http://docs.oracle.com/javase/tutorial/2d/advanced/compositing.html
		AlphaComposite comp = AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f);
		g2I.setComposite(comp);
			
		//draw mouse's trace 
		if(pointlist.size()>0){
		
			
			for(int i=1;i<pointlist.size();i++)
            {
				g2I.setColor(this.getBackground()); 
				g2I.fillOval(pointlist.get(i-1).x,pointlist.get(i-1).y,8,8); 
				 
              }
			
		}
			
		
		g.drawImage(buffImg, 0, 0, null);
		
	}
	
	public boolean isCoverText() {
		return coverText;
	}

	public void setCoverText(boolean coverText) {
		this.coverText = coverText;
	}

	public void rubber(Point p){
		
		//this.p=p;
		pointlist.add(p);

	}
	
	
	
	private class PaintThread implements Runnable{

		@Override
		public void run() {
		
			while(true){
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}




	
}
