package scjp;

class JOBx extends Thread {
	private String jobName;
	private int loopLmt;
	
	public JOBx(int loopLmt,String jobName){
		this.loopLmt = loopLmt;
		this.jobName = jobName;
	}
	
	private void PAUSE(double sec){
		try{Thread.sleep(Math.round(1000.0*sec));}
		catch(InterruptedException ie){};
		
		
	}
	
	public void run(){
		for(int i=1;i<=loopLmt;i++){
			System.out.println(jobName + ": work" +i);
			PAUSE(Math.random());	
		}
	}
}


public class JOB{
	
	public static void main(String[] args){
		JOBx job1= new JOBx(4,"job1");
		JOBx job2= new JOBx(4,"job2");
		job1.start();
		job2.start();
	} 
	
	
}