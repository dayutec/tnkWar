package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;












import lrc.mp3Demo;


public class playerViewer extends JFrame{
	
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
	
	
	public playerViewer(){
		
		mD = new mp3Demo();
		setSize(600, 280);
		initFileLayout();
		initSliderLayout();
		
	//	updateTextContent();
		inputTextContent();
		initButtonLayout();
		
	//	sd() ;
		pack();
		
	/*	
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		
		buttonPanel = new JPanel();
		
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		
		
		
		add(buttonPanel);
		
		ColorAction yellowAction =new ColorAction(Color.YELLOW);
		ColorAction blueAction =new ColorAction(Color.BLUE);
		ColorAction redAction =new ColorAction(Color.RED);
		
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
		
		*/
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
	
	
		
		
		
	public void inputTextContent(){
		

		JPanel panelText = new JPanel();
		panelText.setLayout(null);
		panelText.setPreferredSize(new Dimension(200, 100) );
		panelText.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.red, Color.black));
//		panelText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
		JTextField jtf1;		
        jtf1 = new JTextField("1234567890");  
 
    //    jtf1.setBorder(null);     //消除边界
        jtf1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.ORANGE)); //only bottom has border. 
        jtf1.setOpaque(false);   //透明
        Dimension size = jtf1.getPreferredSize();
        jtf1.setBounds(100, 100, size.width, size.height);
        jtf1.setLocation(100,100);
        
        
        panelText.add(jtf1);
        
        
        
        String[] strt =   stringSplit("dfdg gdsg,gdga,dg.gadg.dagdgdg,3454sdgf,dsgsferyrwe.");    
        String s="";
        int index =0;

        List<JLabel> subJlbSet = new ArrayList<JLabel>();
        List<JTextField> jtfSet = new ArrayList<JTextField>();
        
        List<JLabel> jlbSet = new ArrayList<JLabel>();

        int xPosition =50;
        int yPosition =50;
        Set<Integer> set=new HashSet<Integer>();
		while(true){
			set.add((int)(Math.random()*strt.length));
			if(set.size()==3)
				break;
		}
		System.out.println(set);
		System.out.println(strt.length);

        
		//Initial JLabelset
        for(String string:strt){
 //        	s=string+" "+s;
//        	jtf1.setText(s);      
        	JLabel jl = new JLabel(string);
        	jlbSet.add(jl);
        }
        
        //dig Label's context
        Iterator<Integer> iterator=set.iterator();
        while(iterator.hasNext()){
        	int k = iterator.next();
        	subJlbSet.add(new JLabel(jlbSet.get(k).getText()));
        	
        	jtfSet.add(new JTextField());
        	jlbSet.get(k).setText(null);
        }
        
        
        int subIndex=0;
        for(int i=0; i < jlbSet.size() ;i++){
        
        
        	Dimension sizeJL =null;
        	if(jlbSet.get(i).getText()!=null){
        		

        		sizeJL = jlbSet.get(i).getPreferredSize();
        		jlbSet.get(i).setBounds(xPosition, yPosition, sizeJL.width, sizeJL.height);
        		panelText.add(jlbSet.get(i));
        		xPosition = xPosition +  sizeJL.width +5;
        	}
        	else{
        		
        		sizeJL = subJlbSet.get(subIndex).getPreferredSize();
        	//	subJlbSet.get(index).setBounds(xPosition, yPosition, sizeJL.width, sizeJL.height);
        		
        		jtfSet.get(subIndex).setBounds(xPosition, yPosition, sizeJL.width, sizeJL.height);
        		jtfSet.get(subIndex).setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.ORANGE));
        		jtfSet.get(subIndex).setOpaque(false);   //透明
        		panelText.add(jtfSet.get(subIndex));
        		
        		subIndex ++;
        		xPosition = xPosition +  sizeJL.width +5;
        	}
        	if(xPosition > 200){
        		yPosition += sizeJL.height; 
        		xPosition =50;
        		}
     
        	
        	/*
        	Dimension sizeJL = jl.getPreferredSize();
        	
        	JTextField jt = new JTextField();
        	jtfSet.add(jt);
        	
        	
        	
        	
        	if(set.contains(index)){
        		
        		jtfSet.get(index).setBounds(xposition, 50, sizeJL.width, sizeJL.height);
        		jtfSet.get(index).setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.ORANGE));
        		jtfSet.get(index).setOpaque(false);   //透明
        		panelText.add(jtfSet.get(index));
        		
        	}
        	else
        	{
        		        		
        		jlbSet.get(index).setBounds(xposition, 50, sizeJL.width, sizeJL.height);
        		panelText.add(jlbSet.get(index));
        	}
        	index++;
        	xposition = xposition +  sizeJL.width +5;
        	 */
 		  }
        this.add(panelText,BorderLayout.CENTER);
	}
	
	
	public String[] stringSplit (String path ){
		
		String[] strs=path.split("[,.?! ]");
		  for(String string:strs){
		   System.out.println(string);
		  }
		  
		  return strs;
	}
	
		

	
	public void updateTextContent(){
			
		//	JTextArea textLrc =new JTextArea(5,1);
    	//	textLrc.setColumns(20);
		JLabel jl =new JLabel("1234567890");
	
		
		//a quick brown fox jumps over a lazy dog
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


		  public  void sd() {
		//    JFrame frame = new JFrame();
		//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		    JPanel panelxx = new JPanel();
		    panelxx.setLayout(null);
		    panelxx.setPreferredSize(new Dimension(200, 100) );
		    JLabel label = new JLabel("aaa");
		    panelxx.add(label);
		    Dimension size = label.getPreferredSize();
		    label.setBounds(100, 100, size.width, size.height);
		    
		    label.setLocation(150, 50);
	//	    frame.setSize(300, 200);
	//	    frame.setVisible(true);
		    this.add(panelxx,BorderLayout.CENTER);
		  }
		

	

	
}
