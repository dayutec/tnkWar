package java14;

public class UnsynchBankTest {

	
	
	public static final int NACCOUNT =100;
	public static final double INITIAL_BALANCE =1000;
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b =new Bank(NACCOUNT,INITIAL_BALANCE);
		int i;
		for(i=0;i<NACCOUNT;i++)
		{
			TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
		
	}

}
