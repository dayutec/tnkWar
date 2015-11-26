package sl04;


class myNumber{
	private int number;
	
	myNumber(){
		System.out.println("myNumber ");
	}
	
	
	myNumber(int number){this.number = number ;}
	public int getNumber() {return number;}
	
	
}


class E extends myNumber{
	E(){
		System.out.println("New thread : ");
		
		
	}
	E(int i){
		System.out.println("New thread : ");
	
	}
	

	
}

public class Ex08_4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		E a = new E();
		System.out.println("New thread : "+ a.getNumber());
		
		
	}

}
