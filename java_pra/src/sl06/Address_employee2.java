package sl06;

public class Address_employee2 implements Cloneable {

	private String name ;
	private int age;
	private Address2 address;
	
	public Address_employee2(String name, int age, Address2 address) {
			
			this.name = name;
			this.age = age;
			this.address = address;
		}



	@Override
	public String toString() {
		return "Address_employee2 [name=" + name + ", age=" + age + ", address="
				+ address + "]";
	}
	
	

	@Override
	public Address_employee2 clone() {
		Address_employee2 ae= null;
		try{
			ae= (Address_employee2) super.clone();
			ae.address=address.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
			
		}
		
		return ae;
		
		
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

public Address2 getAddress() {
	return address;
}

public void setAddress(Address2 address) {
	this.address = address;
}





}
