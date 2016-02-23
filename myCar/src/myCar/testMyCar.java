package myCar;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class testMyCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run (){
	
			mainFrame frame = new mainFrame();
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			}
		});
		
	}

}
