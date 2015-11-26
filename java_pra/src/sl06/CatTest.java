package sl06;

class Cato {

	String name;
	int age;
	
    
	
	public Cato(String name, int age) {
		super();
		System.out.println("Construct: ");
		this.name = name;
		this.age = age;
	}
	{
		System.out.println("un static block: ");
		weight =2.0;
	}
	
	double weight = 2.3;
	

	@Override
	public String toString() {
		return "CatTest [name=" + name + ", age=" + age + ", weight=" + weight
				+ "]";
	}

}

public class CatTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cato cat = new Cato("Kitty",2);
		System.out.println(cat);
		Cato cat2 = new Cato("Jerry",3);
		System.out.println(cat2);
	}

}
