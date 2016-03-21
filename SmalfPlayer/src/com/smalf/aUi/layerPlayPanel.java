package com.smalf.aUi;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;




import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.smalf.aControl.panelControlAction;

public class layerPlayPanel {

	
	private static JPanel topPanel;
	private static JPanel middlePanel;
	private static JPanel bottomPanel;
	public static JProgressBar songProgressBar;
  	private  JLabel timeRemain;
  	private  JLabel timeTotal;
  	

  	
  	public void setTimeRemain(String time) {
		timeRemain.setText(time);
	}


	public void setTimeTotal(String time) {
		timeTotal.setText(time);
	}




    
	private panelControlAction pca = new panelControlAction(this);


	static void createTopPanel() { 
		 topPanel = new JPanel(); 
		 String[] columnName = { "����", "�Ա�", "��λ", "�μ���Ŀ", "��ע" }; 
		 String[][] rowData = { { "����", "��", "�����ϵ", "100 �� ,200 ��", "" }, 
		 { "����", "��", "��ѧϵ", "100 �ף�Ǧ��", "" }, 
		 }; 
		            // �������
		 JTable table = new JTable(new DefaultTableModel(rowData, columnName)); 
		            // �����������Ĺ�������
		 JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		            // ���� topPanel �Ĳ���Ϊ BoxLayout��BoxLayout Ϊ��ֱ����
		 topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); 
		            // �ȼ���һ�����ɼ��� Strut���Ӷ�ʹ topPanel �Զ�������һ���Ŀռ�
		 topPanel.add(Box.createVerticalStrut(10)); 
		            // ����������Ĺ������� 
		 topPanel.add(scrollPane); 
		            // �ټ���һ�����ɼ��� Strut���Ӷ�ʹ topPanel �� middlePanel ֮������һ���Ŀռ�
		 topPanel.add(Box.createVerticalStrut(10)); 
		 }
	
	
	     public void createMiddlePanel() { 
		
		 
		 // ���� middlePanel 
		 middlePanel = new JPanel(); 
		 // ����ˮƽ����
		 middlePanel .setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS )); 
		// ��������������ť�� buttonPanel 	
		 JPanel lablePanel = new JPanel(); 
		// ���� bottomPanel Ϊˮƽ����
		 lablePanel.setLayout(new BoxLayout(lablePanel, BoxLayout.X_AXIS )); 
		//Add two Lable
		 timeRemain = new JLabel("00:00:00");
		 timeTotal = new JLabel("00:00:00");
		 lablePanel.add(timeRemain);
		//����һ�� glue, glue �ἷռ������ť֮��Ŀռ�
		 lablePanel.add(Box.createHorizontalGlue ());
		 lablePanel.add(timeTotal);
		 middlePanel.add(lablePanel);
		// ����ѯ��ť���뵽 buttonPanel 
		//ProgressBar of song 			
		 songProgressBar  = new JProgressBar(0,10000);
		 //Add MouseListener
		 songProgressBar.addMouseListener(pca);
		 middlePanel .add(songProgressBar); 
		 // ����һ�� Strut���Ӷ�ʹ bottomPanel �� middlePanel ����֮����������
		 middlePanel.add(Box.createVerticalStrut (5));
			 }
	
	
	
		public void createBottomPanel() { 
		// ����Play��ť
		JButton playButton = new JButton("Play"); 	
		
		playButton.addActionListener(pca);
		
		// �����˳���ť
		JButton pauseButton = new JButton("Pause");		
		pauseButton.addActionListener(pca);
		
		// �����˳���ť
		JButton stopButton = new JButton("Stop");		
		stopButton.addActionListener(pca);
		
			 // ���� bottomPanel 
		bottomPanel = new JPanel(); 
		        // ���� bottomPanel Ϊ��ֱ����
		bottomPanel .setLayout(new BoxLayout(bottomPanel,BoxLayout.Y_AXIS )); 
		        // ��������������ť�� buttonPanel 
		JPanel buttonPanel = new JPanel(); 
			 // ���� bottomPanel Ϊˮƽ����
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS )); 
		        // ����ѯ��ť���뵽 buttonPanel 
		
		//����һ�� glue, glue �ἷռ������ť֮��Ŀռ�
		buttonPanel.add(Box.createHorizontalGlue ()); 
		buttonPanel.add(playButton); 
		
		
		
		
		//����һ�� glue, glue �ἷռ������ť֮��Ŀռ�
		buttonPanel.add(Box.createHorizontalStrut(10));  
		buttonPanel.add(pauseButton); 
		buttonPanel.add(Box.createHorizontalStrut(10)); 
		// ���˳���ť���뵽 buttonPanel 
		buttonPanel.add(stopButton); 
		
		
		
		
		//����һ�� glue, glue �ἷռ������ť֮��Ŀռ�
		buttonPanel.add(Box.createHorizontalGlue ()); 
		
		        // ����һ�� Strut���Ӷ�ʹ bottomPanel �� middlePanel ����֮����������
		bottomPanel .add(Box.createVerticalStrut (10)); 
		        // ���� buttonPanel 
		bottomPanel .add(buttonPanel); 
		        // ����һ�� Strut���Ӷ�ʹ bottomPanel �͵ײ�֮����������
		bottomPanel .add(Box.createVerticalStrut (10)); 
		 }
		
		
		public JPanel initPanel(){
            // ���� topPanel 
		 createTopPanel (); 
				 // ���� middlePanel 
		 createMiddlePanel (); 
				 // ���� bottomPanel 
		 createBottomPanel (); 
				 // �������� topPanel��middlePanel �� bottomPanel �� panelContainer 
		 JPanel panelContainer = new JPanel(); 
				 //panelContainer �Ĳ���Ϊ GridBagLayout 
		 panelContainer.setLayout(new GridBagLayout()); 
		
		 GridBagConstraints c1 = new GridBagConstraints(); 
		 c1.gridx = 0; 
		 c1.gridy = 0; 
		 c1.weightx = 1.0; 
		 c1.weighty = 1.0; 
		 c1.fill = GridBagConstraints.BOTH ; 
				 // ���� topPanel 
		 panelContainer.add(topPanel,c1); 
		
		 GridBagConstraints c2 = new GridBagConstraints(); 
		 c2.gridx = 0; 
		 c2.gridy = 1; 
		 c2.weightx = 1.0; 
		 c2.weighty = 0; 
		 c2.fill = GridBagConstraints.HORIZONTAL ; 
				 // ���� middlePanel 
		 panelContainer.add(middlePanel,c2); 
		
		 GridBagConstraints c3 = new GridBagConstraints(); 
		 c3.gridx = 0; 
		 c3.gridy = 2; 
		 c3.weightx = 1.0; 
		 c3.weighty = 0; 
		 c3.fill = GridBagConstraints.HORIZONTAL ; 
				 // ���� bottomPanel 
		 panelContainer.add(bottomPanel,c3); 
				
				 // ��������
		 JFrame frame = new JFrame("Boxlayout ��ʾ"); 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE ); 
		 panelContainer.setOpaque(true); 
		 frame.setSize(new Dimension(480, 320)); 
		 frame.setContentPane(panelContainer); 
		 frame.setVisible(true); 	
		 
		 return panelContainer;
		}
		
		 
		
		
		public static void main(String[] args) { 
			new layerPlayPanel().initPanel();
		 }
}
