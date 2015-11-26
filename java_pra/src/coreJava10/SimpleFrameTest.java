package coreJava10;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SimpleFrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				SimplerFrame frame = new SimplerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}

}

class SimplerFrame extends JFrame{
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
		public SimplerFrame(){
			setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		}
	}
