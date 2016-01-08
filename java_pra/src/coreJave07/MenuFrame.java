package coreJave07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;



public class MenuFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	private Action saveAction;
	private Action saveAsAction ;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	
	class TestAction extends AbstractAction {

		
		public TestAction(String name){
			super(name);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(getValue(Action.NAME)+" seleted");
		}
		
		
	}
	
	public MenuFrame(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new TestAction("New"));
		
		JMenuItem openItem = new JMenuItem("Open");
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl 0"));
		
		fileMenu.addSeparator();
		
		saveAction  = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		saveAsAction  = new TestAction("SaveAs");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
		
		
		fileMenu.add(new AbstractAction("Exit"){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		
		readonlyItem = new JCheckBoxMenuItem("Read-only");
		readonlyItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean saveOK = !readonlyItem.isSelected();
				saveAction.setEnabled(saveOK);
				saveAsAction.setEnabled(saveOK);
			}
			
			
		});
		
		
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overTypeItem = new JRadioButtonMenuItem("OverType");
		
		group.add(insertItem);
		group.add(overTypeItem);
		
		Action cutAction = new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction = new TestAction("Copy");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction = new TestAction("Paste");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("Paste.gif"));
		
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		
		JMenu optionMenu = new JMenu("Option");
		optionMenu.add(cutAction);
		optionMenu.add(copyAction);
		optionMenu.add(pasteAction);
		
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		
		JMenuItem indexMenu = new JMenuItem("Index");
		helpMenu.setMnemonic('I');
		helpMenu.add(indexMenu);
		
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		JPanel panel  =new JPanel();
		panel.setComponentPopupMenu(popup);
		add(panel);
		panel.addMouseListener(new MouseAdapter(){});
		
	}
	
	
	
	
}
