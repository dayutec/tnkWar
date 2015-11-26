package sl07067;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlarmClock clock  = new AlarmClock(1000,true);
		clock.start();
		JOptionPane.showMessageDialog(null,"quit?");
		System.exit(0);
	}

}
