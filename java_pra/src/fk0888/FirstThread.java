package fk0888;

public class FirstThread extends Thread {
	
	
	private int i ;
	
	public void run()
	{
		for (;i<100;i++)
		{
			System.out.println(getName() +" "+i);
			
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName() +" "+i);
			
			if(i==20)
			{
				new FirstThread().start();
				new FirstThread().start();
			}
		}
		
	}

}
