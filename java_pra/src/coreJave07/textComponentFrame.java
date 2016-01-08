package coreJave07;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class textComponentFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TEXTAREA_ROWS = 8;
	private static final int TEXTAREA_COLUMNS = 20;
	
	public textComponentFrame(){
		
		
		final JTextField textField = new JTextField();
		final JPasswordField passwField = new JPasswordField();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2,2));
		northPanel.add(new JLabel("User name :",SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password :", SwingConstants.RIGHT));
		northPanel.add(passwField);
		
		
		add(northPanel,BorderLayout.NORTH);
		
		final JTextArea textArea = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		add(scrollPane,BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Insert");
		southPanel.add(insertButton);
		
		insertButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText("");
				textArea.append("User name :" + textField.getText() +"\n" +
							    "Password: " + new String(passwField.getPassword())+"\n");
			}
		} );
		
		add(southPanel,BorderLayout.SOUTH);
		pack();
	}
	

	
}
