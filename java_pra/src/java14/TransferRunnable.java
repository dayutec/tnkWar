package java14;

public class TransferRunnable implements Runnable{

	
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;
	
	
	
	
	public TransferRunnable(Bank bank, int fromAccount, double maxAmount) {
		super();
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAmount = maxAmount;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			
			while(true){
			int toAccount = (int)(bank.size()*Math.random());
		//	System.out.printf("Total toAccount %d  ",toAccount);
			double amount = maxAmount * Math.random();
		//	System.out.printf("Amount %f ",amount);
			bank.transfer(fromAccount, toAccount, amount);
			
				Thread.sleep((int)( DELAY * Math.random() ) ) ;
			}
			
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		
	}
	
	
	
	
	
	
	
}
