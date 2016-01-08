package coreJave07;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboxFrame extends BorderFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEFAULT_SIZE=24;
	private JPanel comboPanel;

	public ComboxFrame() {
		super();
		// TODO Auto-generated constructor stub
		comboPanel = new JPanel();
		
		label  =new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
		faceCombo = new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SanSerif");
		faceCombo.addItem("Monaspace");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		
		
		
		
		ActionListener listener  = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				// TODO Auto-generated method stub
				
			}
			
		};
		
		faceCombo.addActionListener(listener);
	//	setLayout(new GridLayout(5,1));
		comboPanel.add(faceCombo);
		add(faceCombo);
		pack();
		
	}
	

}
