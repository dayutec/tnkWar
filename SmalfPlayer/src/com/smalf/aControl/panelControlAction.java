package com.smalf.aControl;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;





import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.sql.Time;

import com.smalf.aService.playService;
import com.smalf.aUi.layerPlayPanel;

public class panelControlAction implements ActionListener , ChangeListener, MouseListener{

	
	    public static final int UNKNOWN = -1;
	    public static final int PLAYING = 0;
	    public static final int PAUSED = 1;
	    public static final int STOPPED = 2;
	    public static final int OPENED = 3;
	    public static final int SEEKING = 4;
	    private String buttonTitle;
	    
	    playService ps = new playService();
	    layerPlayPanel lpp;
	    
	    Timer timer = new Timer(1000,this);
		private int totalTime;
		private int remainTime;
		/*public panelControlAction(String buttonTitle){
	    	
			this.buttonTitle = buttonTitle;
	    }
		 */

		public panelControlAction(layerPlayPanel layerPlayPanel) {
			// TODO Auto-generated constructor stub
			this.lpp = layerPlayPanel;
		}




		@Override
		public void actionPerformed(ActionEvent e) {
					
			if(e.getSource() instanceof JButton )
			{
				JButton s = (JButton)(e.getSource());
				buttonTitle = s.getText();

				switch(buttonTitle){
					case "Pause" :  ps.pauseAudio();
									System.out.println("Pause");
									timer.stop();
									break;
					case "Resume" : ps.resumeAudio();
									System.out.println("Resume"); 
									timer.start();
									break;
					case "Play"  :  ps.playAudio(null);
									//updateSongBar();
									initTimeLable();
									System.out.println("Play"); 
									timer.start();
									break;
					case "Stop"  :  ps.stopAudio();
									System.out.println("Stop");
									timer.stop();
									break;
					case "Files"  : //mD.ChooseMP3();
									//lableFile.setText(mD.songName);
									System.out.println("Choose files"); 
									break;
					default: break;
				}
				
				
			//	System.out.println("play");
			//	panel.setBackground(Color.BLUE);
			}
			
			if(e.getSource() == timer ){
				
				

		           if (ps.getFISPosition() >= ps.getFISEnd()){
		        	   layerPlayPanel.songProgressBar.setValue(1);
		        	   remainTime =0;
		        	   setTimeLable();
		        	   timer.stop();
		        	   return;
		           }else{
		        	   
		        	   double p = (double)ps.getFISPosition()/ps.getFISEnd();
		        	   int t = (int) (10000*p);
		        	   layerPlayPanel.songProgressBar.setValue(t);
		        	   setTimeLable();
		           }

		        	  

		
			}
			
		}




		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(ps.getM_status()==STOPPED || ps.getM_status()==UNKNOWN || !(e.getSource() instanceof JProgressBar) ){
				return;
			}			
			else{
				JProgressBar bar = (JProgressBar) e.getSource();
				//get total length
				int barLength = bar.getWidth();
				//get clicked position
				double xPosition = e.getPoint().getX();
				//get percent
				double percent = xPosition/barLength;
			
				System.out.println(bar.getWidth());
				
				ps.seekAudio(percent);
				layerPlayPanel.songProgressBar.setValue((int) (10000*percent));
				remainTime = (int) (totalTime*(1-percent));
				setTimeLable();
			}
		}


		public void setTimeLable(){
			
			
			int l = remainTime--;
			
			int hh=l/3600;
			int mm=l/60;
			int ss=l%60;
			Time t = new Time(hh,mm,ss);
						
			lpp.setTimeRemain(t.toString());
	
		}
		
		public void initTimeLable(){
			
			remainTime = totalTime = ps.getSongTotalTime();
			int hh=totalTime/3600;
			int mm=totalTime/60;
			int ss=totalTime%60;
			Time t = new Time(hh,mm,ss);
			
			
			lpp.setTimeRemain(t.toString());
			lpp.setTimeTotal(t.toString());
		}
		
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
}
