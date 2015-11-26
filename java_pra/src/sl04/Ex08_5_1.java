package sl04;


/*
final class myNumber051{
	int number =5;
	
}*/

 class myNumber051{
	int number =5;
	public int getsuperNumber(){return this.number;}
	int work(int x){return 20;}
	
}


class E051 extends myNumber051{
	
	int number =10;
	//public int getsuperNumber(){return super.number;}
	public int getthisNumber(){return this.number;}
	
	//long work(int x){return 40L;}
	
}



public class Ex08_5_1 {
	
	static final int zero =22 ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		E051 E1 = new E051();
		E1.getthisNumber();
		int i='5';
		System.out.println(i);
		
		
		
		System.out.println(zero);
	}

}
