package com.smalf.main;



import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.SubstanceLookAndFeel;





public class mainThread {
	
public static void main(String[] args) {
	
	try {
		// 设置观感
		UIManager
				.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");
		// 设置水印
		SubstanceLookAndFeel.
				setCurrentWatermark("org.jvnet.substance.watermark.SubstanceMosaicWatermark");
		// 设置渐变渲染
		SubstanceLookAndFeel
				.setCurrentGradientPainter("org.jvnet.substance.painter.WaveGradientPainter");

		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
	} catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e) {
		e.printStackTrace();
	}

		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				
			//	playerViewer pv =new playerViewer();
			//	pv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//	pv.setVisible(true);
			}
			
		});
	}

}