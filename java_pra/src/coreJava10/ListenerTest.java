package coreJava10;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ListenerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				JFrame bFrame  = new ButtonFrame();
				bFrame.setTitle("Listener Test");
				bFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				bFrame.setVisible(true);
			}
			
			
			
		}
				
				
				
				);
		
		
		
	}

}


