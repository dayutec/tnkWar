package coreJave07;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class BorderFrame extends radioButtonFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup group;
	private JPanel demoPanel;
	private JPanel buttonPanel;
	
	public BorderFrame() {
		super();
		// TODO Auto-generated constructor stub
		 group =new ButtonGroup();
		 demoPanel = new JPanel();
		 buttonPanel = new JPanel();
		 
		 addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
		 addRadioButton("Raised bevel",  BorderFactory.createRaisedBevelBorder());
		 addRadioButton("Etched", 		 BorderFactory.createEtchedBorder());
		 addRadioButton("Line", 		 BorderFactory.createLineBorder(Color.BLUE));
		 addRadioButton("Matte", 		 BorderFactory.createMatteBorder(10,10,10,10,Color.BLUE));
		 addRadioButton("Empty", 		 BorderFactory.createEmptyBorder());
		
		 Border etched = BorderFactory.createEtchedBorder();
		 Border titleBorder = BorderFactory.createTitledBorder(etched, "Border typese");
		 buttonPanel.setBorder(titleBorder);
		 
		// setLayout(new GridLayout(9,1));
		 
		 add(buttonPanel);
		 add(demoPanel);
		 pack();
	}


	private void addRadioButton(String name, final Border border) {
		// TODO Auto-generated method stub
		
		JRadioButton button = new JRadioButton(name);
				
		ActionListener listener  = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				// TODO Auto-generated method stub
				demoPanel.setBorder(border);
			}
			
		};
		
		button.addActionListener(listener);
		group.add(button);
		buttonPanel.add(button);
	}

	
	
}
