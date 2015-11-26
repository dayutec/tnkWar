package sl06;

public class Address_employee implements Cloneable{

	private String name ;
	private int age;
	private Address address;
	
	public Address_employee() {
		// TODO Auto-generated constructor stub
	}

	public Address_employee(String name, int age, Address address) {
		
		this.name = name;
		this.age = age;
		this.address = address;
	}

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



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Address_employee [name=" + name + ", age=" + age + ", address="
				+ address + "]";
	}

	@Override
	public Address_employee clone() {
		Address_employee ae= null;
		try{
			ae= (Address_employee) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
			
		}
		
		
		return ae;
		
		
	}






	
	

}
