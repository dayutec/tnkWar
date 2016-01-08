package coreJave07;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class simpleFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated methfhod stub
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run (){
		//	simpleFrame frame = new simpleFrame();
		//	textComponentFrame frame = new textComponentFrame();
		//	radioButtonFrame frame = new radioButtonFrame();
			
		//	BorderFrame frame = new BorderFrame();	
				
		//	ComboxFrame frame = new ComboxFrame();
				
		//	MenuFrame frame = new MenuFrame();	
			fontFrame frame = new fontFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			}
		});

	}

}

class simpleFrame extends JFrame{
	
	private static final int DEFAULT_WIDTH =300;
	private static final int DEFAULT_HEIGHT =300;
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int w= screenSize.width/2;
	int h= screenSize.height/2;
	
	public simpleFrame(){
		//setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setSize(w,h);
		
		Image img = new ImageIcon("icon.gif").getImage();
			
		setIconImage(img);
		CalculatorPanel cp= new CalculatorPanel();
		add(cp);
		
	
		
		
		
	}
	
	
	
	
}

