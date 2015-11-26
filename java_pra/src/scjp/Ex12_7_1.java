package scjp;

class NumberIssue{
	int iniNumber, numberInterval;

	public NumberIssue(int iniNumber, int numberInterval) {
		super();
		this.iniNumber = iniNumber;
		this.numberInterval = numberInterval;
	}
	
	//public synchronized int getNumber(){
	  public int getNumber(){
		int num = iniNumber;
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ie){};
		
		iniNumber = iniNumber + numberInterval;
		System.out.println("call NI getnumber");
		return (num);
	}
	
	
}


class Passenger extends Thread{
	int number ;
	NumberIssue NI;
	
	public Passenger(NumberIssue nI) {
		super();
		this.NI = nI;
	}
	
	public void run(){
		number = NI.getNumber();
	}
	
	
}



public class Ex12_7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberIssue NI;
		Passenger p1,p2,p3,p4;
		
		NI =  new NumberIssue(1,2);
		p1 = new Passenger(NI); p1.start();
		p2 = new Passenger(NI); p2.start();
		p3 = new Passenger(NI); p3.start();
		p4 = new Passenger(NI); p4.start();
	
		try{
			p1.join();p2.join();p3.join();p4.join();
		}catch(InterruptedException ie){};
		
		System.out.println("P1 number :" + p1.number);
		System.out.println("P2 number :" + p2.number);
		System.out.println("P3 number :" + p3.number);
		System.out.println("P4 number :" + p4.number);
		
	}

}
