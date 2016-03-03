package gui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;


public class textContentPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean coverText = true;
	private Point p;
	private ArrayList<Point> pointlist = new ArrayList<Point>();

	 public textContentPanel(){
			
		
		new Thread( new PaintThread()).start();

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g); //very important
		
		Graphics2D g2 = (Graphics2D) g;
		
	
		
		if(coverText ){
			
		//	AlphaComposite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f);
         //   g2.setComposite(comp);
 
			g2.setColor(Color.DARK_GRAY);
			g2.fillRect(30, 40, 200, 20);
			//coverText=false;
		}
		
		//g2.setXORMode(Color.GRAY);
		//g2.fillRect(30, 40, 200, 20);
		
		if(pointlist.size()>0){
			
		
			
			for(int i=1;i<pointlist.size();i++)
            {
                g2.setColor(this.getBackground());
                AlphaComposite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
                g2.setComposite(comp);
                g2.setStroke(new BasicStroke(3.0f));
                g2.drawLine(pointlist.get(i-1).x,pointlist.get(i-1).y,pointlist.get(i).x,pointlist.get(i).y);
               
              }
			
		}
		
		g.setColor(Color.DARK_GRAY);
		g.drawString("The quick brown fox jumps over a lazy dog",30,50);
		
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
