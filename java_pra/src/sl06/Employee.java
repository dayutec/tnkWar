package sl06;

public class Employee {

	
	private String name;
	private int age;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}



	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
