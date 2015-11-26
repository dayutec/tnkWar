package sl07067;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;


public class AlarmClock {

	private int delay;
	private boolean flag;
	public AlarmClock(int delay,boolean flag){
		this.delay = delay ;
		this.flag = flag;
		
	}
	
	public void start(){
		class Printer implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SimpleDateFormat format = new SimpleDateFormat("k:m:s");
				String result = format.format(new Date());
				System.out.println("Time :" + result);
				if(flag){
					Toolkit.getDefaultToolkit().beep();
				}
				
			}
			
		}
		
		new Timer(delay , new Printer()).start();
		
	}
	
}
