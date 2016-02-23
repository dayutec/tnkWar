package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SimpleFrameTest {

public static void main(String[] args) {
		
		

		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				playerViewer pv =new playerViewer();
				pv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pv.setVisible(true);
			}
			
		});
	}

}

