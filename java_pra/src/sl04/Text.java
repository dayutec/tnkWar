package sl04;


class Base{
	public void Base(){
		System.out.println("Base");
	}
	
	public Base(int i )	{
		System.out.println("Base with a P");
	}
}



public class Text extends Base{

	
	
	public Text(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		
	}
}
