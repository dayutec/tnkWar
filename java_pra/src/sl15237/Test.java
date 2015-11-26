package sl15237;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ThreadState state = new ThreadState();
		Thread thread = new Thread(state);
		System.out.println("New thread : "+ thread.getState());
		
		thread.start();
		System.out.println("Start thread : "+ thread.getState());
		
		thread.sleep(100);
		System.out.println("100 Account waiting : "+ thread.getState());
		
		thread.sleep(1000);
		System.out.println("Waiting thread : "+ thread.getState());
		
		state.notifyNow();
		System.out.println("revoke thread : "+ thread.getState());
		
		thread.sleep(1000);
		System.out.println("Stop thread : "+ thread.getState());

		
		
		
		
		
	}

}
