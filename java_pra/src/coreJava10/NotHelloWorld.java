package coreJava10;

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NotHelloWorld extends JApplet {

	public void init(){
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JLabel label = new JLabel("Not a Hello,World applet.", SwingConstants.CENTER);
				add(label);
			}
		});
	}
}
