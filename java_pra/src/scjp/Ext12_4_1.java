package scjp;

class JOB4 extends Thread{
	
	
	private String jobName;
	private int loopLmt;
	
	public JOB4(int loopLmt,String jobName){
		this.loopLmt = loopLmt;
		this.jobName=jobName;
	}

	private void PAUSE(double sec){
		try{Thread.sleep(Math.round(1000.0*sec));}
		catch(InterruptedException ie){};
	}
	
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=loopLmt;i++){
			System.out.println(jobName + ": work" +i);
			PAUSE(Math.random());
	}
	
	
	
}

}


public class Ext12_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Thread job1= new Thread(new JOB2(4,"job1"));
	//	Thread job2= new Thread(new JOB2(4,"job2"));
		JOB4 job1 = new JOB4(4,"job1");
		JOB4 job2 = new JOB4(8,"job2");
			
		
		job1.start();
		job2.start();
		
		System.out.println("job1 is alive :" + job1.isAlive());
		try{ job1.join();}
			catch(InterruptedException ie){}
		
		System.out.println("job1 is alive :" + job1.isAlive());
		
	}

}

