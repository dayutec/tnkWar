package sl15242;

public class EmergencyThread implements Runnable {

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<6; i++)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			System.out.println("Emergency state : "+i+" sent out ");
			
		}
	}

}

