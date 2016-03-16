package com.smalf.aUi;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class layerBoxTest {

	
	private static JPanel topPanel;
	private static JPanel middlePanel;
	private static JPanel bottomPanel;



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
	
	
	static void createMiddlePanel() { 
		 // ���� middlePanel 
		 middlePanel = new JPanel(); 
		 // ����ˮƽ����
		 middlePanel .setLayout(new BoxLayout(middlePanel,BoxLayout.X_AXIS )); 
		 // ������ǩ�˶�����Ŀ		
		 JLabel sourceLabel = new JLabel("�˶�����Ŀ��"); 
		 sourceLabel.setAlignmentY(Component.TOP_ALIGNMENT ); 
		 sourceLabel.setBorder(BorderFactory.createEmptyBorder (4, 5, 0, 5)); 
		 // �����б��˶�����Ŀ
		 DefaultListModel listModel = new DefaultListModel(); 
		 listModel.addElement("100 ��"); 
		 listModel.addElement("200 ��"); 
		 listModel.addElement("400 ��"); 
		 listModel.addElement("��Զ"); 
		 listModel.addElement("����"); 
		 listModel.addElement("Ǧ��"); 
		 JList sourceList = new JList(listModel); 
		 sourceList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ); 
		 sourceList.setVisibleRowCount(5); 
		 JScrollPane sourceListScroller = new JScrollPane(sourceList); 
		 sourceListScroller.setPreferredSize(new Dimension(120, 80)); 
		 sourceListScroller 
		 .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ); 
		 sourceListScroller.setAlignmentY(Component.TOP_ALIGNMENT ); 
		 // ��������ߵ� Panel 
		 JPanel sourceListPanel = new JPanel(); 
		 // ����ߵ� Panel ����ˮƽ����
		 sourceListPanel.setLayout(new BoxLayout(sourceListPanel, 
		 BoxLayout.X_AXIS )); 
		 // �����ǩ������ߵ� Panel 
		 sourceListPanel.add(sourceLabel); 
		 // �����б��˶�����Ŀ������ߵ� Panel 
		 sourceListPanel.add(sourceListScroller); 
		 sourceListPanel.setAlignmentY(Component.TOP_ALIGNMENT ); 
		 sourceListPanel.setBorder(BorderFactory.createEmptyBorder (0, 0, 0, 30)); 
		 // ������ߵ� Panel ���뵽 middlePanel 
		 middlePanel .add(sourceListPanel); 
		 // �����м��������ť		
		 JButton toTargetButton = new JButton(">>"); 
		 JButton toSourceButton = new JButton("<<"); 
		 // �����м�� Panel 
		 JPanel buttonPanel = new JPanel(); 
		 // �м�� Panel ����ˮƽ����
		 buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS )); 
		 // ����ť >> ���뵽�м�� Panel 
		 buttonPanel.add(toTargetButton); 

		//������ť֮�����һ�����ɼ��� rigidArea			
		 buttonPanel.add(Box.createRigidArea (new Dimension(15, 15))); 
		 // ����ť << ���뵽�м�� Panel 
		 buttonPanel.add(toSourceButton); 
		 buttonPanel.setAlignmentY(Component.TOP_ALIGNMENT ); 
		 buttonPanel.setBorder(BorderFactory.createEmptyBorder (15, 5, 15, 5)); 
		 // ���м�� Panel ���뵽 middlePanel 
		 middlePanel .add(buttonPanel); 
		 // ������ǩ��ѯ��Ŀ
		 JLabel targetLabel = new JLabel("��ѯ��Ŀ��"); 
		 targetLabel.setAlignmentY(Component.TOP_ALIGNMENT ); 
		 targetLabel.setBorder(BorderFactory.createEmptyBorder (4, 5, 0, 5)); 

		// �����б��ѯ��Ŀ			
		 DefaultListModel targetListModel = new DefaultListModel(); 
		 targetListModel.addElement("100 ��"); 
		 JList targetList = new JList(targetListModel); 
		 targetList 
		 .setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ); 
		 targetList.setVisibleRowCount(5); 
		 JScrollPane targetListScroller = new JScrollPane(targetList); 
		 targetListScroller.setPreferredSize(new Dimension(120, 80)); 
		 targetListScroller 
		 .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ); 
		 targetListScroller.setAlignmentY(Component.TOP_ALIGNMENT ); 
		 // �������ұߵ� Panel 
		 JPanel targetListPanel = new JPanel(); 
		 // �������ұߵ� Panel Ϊˮƽ����
		 targetListPanel.setLayout(new BoxLayout(targetListPanel, 
		 BoxLayout.X_AXIS )); 
		 // ����ǩ��ѯ��Ŀ�ӵ����ұߵ� Panel 
		 targetListPanel.add(targetLabel); 
		 // ���б��ѯ��Ŀ�ӵ����ұߵ� Panel 
		 targetListPanel.add(targetListScroller); 
		 targetListPanel.setAlignmentY(Component.TOP_ALIGNMENT ); 
		 targetListPanel.setBorder(BorderFactory.createEmptyBorder (0, 30, 0, 0)); 
		 // ������ұߵ� Panel ���뵽 middlePanel 
		 middlePanel .add(targetListPanel); 
			 }
	
	
	
		static void createBottomPanel() { 
		        // ������ѯ��ť
		JButton actionButton = new JButton("��ѯ"); 
			 // �����˳���ť
		JButton closeButton = new JButton("�˳�"); 
			 // ���� bottomPanel 
		bottomPanel = new JPanel(); 
		        // ���� bottomPanel Ϊ��ֱ����
		bottomPanel .setLayout(new BoxLayout(bottomPanel,BoxLayout.Y_AXIS )); 
		        // ��������������ť�� buttonPanel 
		JPanel buttonPanel = new JPanel(); 
			 // ���� bottomPanel Ϊˮƽ����
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS )); 
		        // ����ѯ��ť���뵽 buttonPanel 
		buttonPanel.add(actionButton); 
		
		//����һ�� glue, glue �ἷռ������ť֮��Ŀռ�			
		buttonPanel.add(Box.createHorizontalGlue ()); 
		        // ���˳���ť���뵽 buttonPanel 
		buttonPanel.add(closeButton); 
		        // ����һ�� Strut���Ӷ�ʹ bottomPanel �� middlePanel ����֮����������
		bottomPanel .add(Box.createVerticalStrut (10)); 
		        // ���� buttonPanel 
		bottomPanel .add(buttonPanel); 
		        // ����һ�� Strut���Ӷ�ʹ bottomPanel �͵ײ�֮����������
		bottomPanel .add(Box.createVerticalStrut (10)); 
		 }
		
		
		
		public static void main(String[] args) { 
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
		 }
}
