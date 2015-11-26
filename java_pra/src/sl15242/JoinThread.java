package sl15242;

public class JoinThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread thread = new Thread(new EmergencyThread() );
		thread.start();
		for(int i=1;i<6;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Normal state : "+i+" sent out ");
			
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}

}
