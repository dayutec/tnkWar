package sl15237;

public class ThreadState implements Runnable {

	public synchronized void waitforASecond() throws InterruptedException{
		
		System.out.println("wanit 500 start");
		wait(500);
		System.out.println("wanit 500 end");
	} 
	
	
	public synchronized void waitforYears() throws InterruptedException{
		
		System.out.println("wanit forever start");
		wait();
		System.out.println("wanit forever end");
	} 
	
	public synchronized void notifyNow() throws InterruptedException{
		
		notify();
		System.out.println("notify end");
	} 
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("start");
			waitforASecond();
			waitforYears();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
