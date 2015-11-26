package scjp;

class JOB2 implements Runnable{
	
	
	private String jobName;
	private int loopLmt;
	
	public JOB2(int loopLmt,String jobName){
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


public class Ex12_3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread job1= new Thread(new JOB2(4,"job1"));
		Thread job2= new Thread(new JOB2(4,"job2"));
		job1.start();
		job2.start();
	}

}
