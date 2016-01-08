package coreJave07;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class radioButtonFrame extends JFrame {

	protected JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	private static final int DEFAULT_SIZE = 36;
	
	public radioButtonFrame(){
		
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		
		add(label,BorderLayout.NORTH);
		
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("samll",8);
		addRadioButton("Medium",12);
		addRadioButton("Large",18);
		addRadioButton("Extra Large",36);
		
	//	add(buttonPanel,BorderLayout.CENTER);
		
		add(buttonPanel);
		setLayout(new GridLayout(9,1));
		pack();
		
	}

	private void addRadioButton(String name,final int size) {
		// TODO Auto-generated method stub
		boolean selected  = size == DEFAULT_SIZE;
		JRadioButton button = new JRadioButton(name,selected);
		group.add(button);
		buttonPanel.add(button);
		
		ActionListener listener  = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				label.setFont(new Font("Serif",Font.PLAIN,size));
			}
			
		};
		
		button.addActionListener(listener);
		
	} 
	
}
