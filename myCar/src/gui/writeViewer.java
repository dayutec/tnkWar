package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




import lrc.mp3Demo;


public class writeViewer extends JFrame{
	
	mp3Demo mD;
	JPanel panel;
	JPanel panelFile;
	JPanel panelTextArea;
	JPanel coverPanel;
	textContentPanel panelSlider;
	JLabel lableFile;
	
	Image image ;
	
	private JSlider sliderSongLengthBar;
	
	private buttonAction BFileA;
		
	private buttonAction BPlayA;
	private buttonAction BStopA;
	private buttonAction BPauseA;
	private buttonAction BResumeA;
	
	private sliderAction songBarAction;
//	private boolean initBar = true;
	public boolean autoPlay = true;

	private sliderMouseAction sMA;
//	private boolean isMouseReleased = true;
	
	
	public writeViewer(){
		
		mD = new mp3Demo();
		setSize(600, 280);
		initFileLayout();
		initSliderLayout();
		
		updateTextContent();
		
		initButtonLayout();
		
		
		pack();
		

	}
	
	
	private void initFileLayout() {
		JButton buttonFile = new JButton("Files");
		lableFile = new JLabel("235");
		panelFile = new JPanel();
		panelFile.add(buttonFile);
		panelFile.add(lableFile);
		add(panelFile,BorderLayout.NORTH);
		BFileA = new buttonAction("Files");
		buttonFile.addActionListener(BFileA);
	

	}
	
	private void initSliderLayout() {
		// Add Slider Bar for user for dragging song's position
		sliderSongLengthBar = new JSlider(0,100,0);
		songBarAction = new sliderAction();
		sliderSongLengthBar.addChangeListener(songBarAction);
	    // Add mouse Action Listener , but replaced by getValueIsAdjusting() 
		// change variety of autoPlay
		sMA = new sliderMouseAction();
		sliderSongLengthBar.addMouseListener(sMA);

		panelFile.add(sliderSongLengthBar);
	
	}
	
	
		
		
		
		
		

	
	public void updateTextContent(){
			
		//	JTextArea textLrc =new JTextArea(5,1);
    	//	textLrc.setColumns(20);
		JLabel jl =new JLabel("1234567890");
		
		panelSlider = new textContentPanel();
			
		panelSlider.setPreferredSize(new Dimension(200, 100) );

		panelSlider.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.red, Color.black));

		panelSlider.add(jl);
		panelSlider.addMouseListener(sMA);
		panelSlider.addMouseMotionListener(sMA);
		add(panelSlider,BorderLayout.CENTER);


	}
	
	public void initButtonLayout(){
		JButton buttonPlay = new JButton("Play");
		JButton buttonStop = new JButton("Stop");
		JButton buttonPause = new JButton("Pause");
		JButton buttonResume = new JButton("Resume");
		
		panel  = new JPanel();
		
		GridBagLayout lyout = new GridBagLayout();
		panel.setLayout(lyout );
		
		panel.add(buttonPlay);
		panel.add(buttonStop);
		panel.add(buttonPause);
		panel.add(buttonResume);
		
		add(panel,BorderLayout.SOUTH);
		
		BPlayA = new buttonAction("Play");
		BStopA = new buttonAction("Stop");
		BPauseA = new buttonAction("Pause"); 
		BResumeA = new buttonAction("Resume"); 
		
		buttonPlay.addActionListener(BPlayA);
		buttonStop.addActionListener(BStopA);
		buttonPause.addActionListener(BPauseA);
		buttonResume.addActionListener(BResumeA);
		
		System.out.println("init end");
	}
	
	
	
	public void updateSongBar(){
		
		
		long songLength = mD.getSongLength();
		sliderSongLengthBar.setMaximum( (int) songLength);
		System.out.println(sliderSongLengthBar.getMaximum());	
		
		new Thread() {

			@Override
			public void run() {
			
				while(!mD.player.isComplete()){
				try {
					sleep(1000);	
					long songPosition = mD.UpdateSongPosition();
					sliderSongLengthBar.setValue( sliderSongLengthBar.getMaximum()-(int) songPosition );
						
					//System.out.println(sliderSongLengthBar.getValue());
				
				
					} catch (InterruptedException e) {
					}
				}
			}
		}.start();
	
	}
	
	
	private class sliderAction implements ChangeListener{

		

		public void stateChanged(ChangeEvent e) {
						
			if(autoPlay)return;
			
			else{		
				JSlider slider = (JSlider) e.getSource();
				if(slider.getValueIsAdjusting()) return ;
				int len = slider.getValue();
				mD.playMp3Anywhere(len);
				autoPlay = true;
			}
			
		}
		
		
	}
	
	
	
	
	
	private class sliderMouseAction extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			//autoPlay = false;
			panelSlider.setCoverText(false);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			autoPlay = false;
		//	panelSlider.rubber(e.getPoint());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			
			panelSlider.rubber(e.getPoint());
		//	System.out.println("mouseMoved");
		}
		
	

		
	}
	
	
	private class buttonAction implements ActionListener{

		private String buttonTitle ;
		public buttonAction(String buttonTitle) {
			// TODO Auto-generated constructor stub
			this.buttonTitle = buttonTitle;
		}

		public void actionPerformed(ActionEvent e) {
					
			switch(buttonTitle){
				case "Pause" :  mD.PauseMp3();
								System.out.println("Pause"); 
								break;
				case "Resume" : mD.ResumeMp3();
								System.out.println("Resume"); 
								break;
				case "Play"  :  mD.readMp3(null);
								updateSongBar();
								System.out.println("Play"); 
								break;
				case "Stop"  :  mD.stopMp3();
								System.out.println("Stop"); 
								break;
				case "Files"  : mD.ChooseMP3();
								lableFile.setText(mD.songName);
								System.out.println("Choose files"); 
								break;
				default: break;
			}
			
			
		//	System.out.println("play");
		//	panel.setBackground(Color.BLUE);
		}
	}
	
	/*
	private class buttonPlayAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mD.readMp3();
			System.out.println("play");
		//	panel.setBackground(Color.BLUE);
		}
	}
	
	
	
	private class buttonStopAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Stop");
				mD.stopMp3();
			}
		
	}
	*/

	

	

	
}
