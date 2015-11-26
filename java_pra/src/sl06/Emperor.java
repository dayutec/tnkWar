package sl06;

public class Emperor {

	private static Emperor emperor = null;
	
	private Emperor() {
		// TODO Auto-generated constructor stub
	}
	
	public static Emperor getInstance(){
		if(emperor == null)
		{
			emperor = new Emperor();
		}
		return emperor;
	}
	
	public void getName(){
		System.out.println("I am Emperor : King Kevin");
	}
	

}
