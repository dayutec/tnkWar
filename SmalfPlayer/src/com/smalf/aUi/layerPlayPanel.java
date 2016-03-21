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
		 String[] columnName = { "姓名", "性别", "单位", "参加项目", "备注" }; 
		 String[][] rowData = { { "张三", "男", "计算机系", "100 米 ,200 米", "" }, 
		 { "李四", "男", "化学系", "100 米，铅球", "" }, 
		 }; 
		            // 创建表格
		 JTable table = new JTable(new DefaultTableModel(rowData, columnName)); 
		            // 创建包含表格的滚动窗格
		 JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		            // 定义 topPanel 的布局为 BoxLayout，BoxLayout 为垂直排列
		 topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); 
		            // 先加入一个不可见的 Strut，从而使 topPanel 对顶部留出一定的空间
		 topPanel.add(Box.createVerticalStrut(10)); 
		            // 加入包含表格的滚动窗格 
		 topPanel.add(scrollPane); 
		            // 再加入一个不可见的 Strut，从而使 topPanel 和 middlePanel 之间留出一定的空间
		 topPanel.add(Box.createVerticalStrut(10)); 
		 }
	
	
	     public void createMiddlePanel() { 
		
		 
		 // 创建 middlePanel 
		 middlePanel = new JPanel(); 
		 // 采用水平布局
		 middlePanel .setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS )); 
		// 创建包含两个按钮的 buttonPanel 	
		 JPanel lablePanel = new JPanel(); 
		// 设置 bottomPanel 为水平布局
		 lablePanel.setLayout(new BoxLayout(lablePanel, BoxLayout.X_AXIS )); 
		//Add two Lable
		 timeRemain = new JLabel("00:00:00");
		 timeTotal = new JLabel("00:00:00");
		 lablePanel.add(timeRemain);
		//加入一个 glue, glue 会挤占两个按钮之间的空间
		 lablePanel.add(Box.createHorizontalGlue ());
		 lablePanel.add(timeTotal);
		 middlePanel.add(lablePanel);
		// 将查询按钮加入到 buttonPanel 
		//ProgressBar of song 			
		 songProgressBar  = new JProgressBar(0,10000);
		 //Add MouseListener
		 songProgressBar.addMouseListener(pca);
		 middlePanel .add(songProgressBar); 
		 // 加入一个 Strut，从而使 bottomPanel 和 middlePanel 上下之间留出距离
		 middlePanel.add(Box.createVerticalStrut (5));
			 }
	
	
	
		public void createBottomPanel() { 
		// 创建Play按钮
		JButton playButton = new JButton("Play"); 	
		
		playButton.addActionListener(pca);
		
		// 创建退出按钮
		JButton pauseButton = new JButton("Pause");		
		pauseButton.addActionListener(pca);
		
		// 创建退出按钮
		JButton stopButton = new JButton("Stop");		
		stopButton.addActionListener(pca);
		
			 // 创建 bottomPanel 
		bottomPanel = new JPanel(); 
		        // 设置 bottomPanel 为垂直布局
		bottomPanel .setLayout(new BoxLayout(bottomPanel,BoxLayout.Y_AXIS )); 
		        // 创建包含两个按钮的 buttonPanel 
		JPanel buttonPanel = new JPanel(); 
			 // 设置 bottomPanel 为水平布局
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS )); 
		        // 将查询按钮加入到 buttonPanel 
		
		//加入一个 glue, glue 会挤占两个按钮之间的空间
		buttonPanel.add(Box.createHorizontalGlue ()); 
		buttonPanel.add(playButton); 
		
		
		
		
		//加入一个 glue, glue 会挤占两个按钮之间的空间
		buttonPanel.add(Box.createHorizontalStrut(10));  
		buttonPanel.add(pauseButton); 
		buttonPanel.add(Box.createHorizontalStrut(10)); 
		// 将退出按钮加入到 buttonPanel 
		buttonPanel.add(stopButton); 
		
		
		
		
		//加入一个 glue, glue 会挤占两个按钮之间的空间
		buttonPanel.add(Box.createHorizontalGlue ()); 
		
		        // 加入一个 Strut，从而使 bottomPanel 和 middlePanel 上下之间留出距离
		bottomPanel .add(Box.createVerticalStrut (10)); 
		        // 加入 buttonPanel 
		bottomPanel .add(buttonPanel); 
		        // 加入一个 Strut，从而使 bottomPanel 和底部之间留出距离
		bottomPanel .add(Box.createVerticalStrut (10)); 
		 }
		
		
		public JPanel initPanel(){
            // 创建 topPanel 
		 createTopPanel (); 
				 // 创建 middlePanel 
		 createMiddlePanel (); 
				 // 创建 bottomPanel 
		 createBottomPanel (); 
				 // 创建包含 topPanel，middlePanel 和 bottomPanel 的 panelContainer 
		 JPanel panelContainer = new JPanel(); 
				 //panelContainer 的布局为 GridBagLayout 
		 panelContainer.setLayout(new GridBagLayout()); 
		
		 GridBagConstraints c1 = new GridBagConstraints(); 
		 c1.gridx = 0; 
		 c1.gridy = 0; 
		 c1.weightx = 1.0; 
		 c1.weighty = 1.0; 
		 c1.fill = GridBagConstraints.BOTH ; 
				 // 加入 topPanel 
		 panelContainer.add(topPanel,c1); 
		
		 GridBagConstraints c2 = new GridBagConstraints(); 
		 c2.gridx = 0; 
		 c2.gridy = 1; 
		 c2.weightx = 1.0; 
		 c2.weighty = 0; 
		 c2.fill = GridBagConstraints.HORIZONTAL ; 
				 // 加入 middlePanel 
		 panelContainer.add(middlePanel,c2); 
		
		 GridBagConstraints c3 = new GridBagConstraints(); 
		 c3.gridx = 0; 
		 c3.gridy = 2; 
		 c3.weightx = 1.0; 
		 c3.weighty = 0; 
		 c3.fill = GridBagConstraints.HORIZONTAL ; 
				 // 加入 bottomPanel 
		 panelContainer.add(bottomPanel,c3); 
				
				 // 创建窗体
		 JFrame frame = new JFrame("Boxlayout 演示"); 
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
