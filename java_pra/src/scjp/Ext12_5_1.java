package scjp;

public class Ext12_5_1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JOBx job1 =new JOBx(4,"job1");
		JOBx job2 =new JOBx(4,"job2");
		
		job1.start();
		job2.start();
		job2.suspend();
		System.out.println("job2 is suspend");
		
		try{ job1.join();}
			catch(InterruptedException ie){}
		job2.resume();
		System.out.println("job1 is resume");
	}

}
