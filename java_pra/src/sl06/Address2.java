package sl06;

public class Address2 implements Cloneable {

	
	private  String state;
	private String province;
	private String city;
	
	
	
	public Address2(String state, String province, String city) {
		super();
		this.state = state;
		this.province = province;
		this.city = city;
	}


	@Override
	public String toString() {
		return "Address [state=" + state + ", province=" + province + ", city="
				+ city + "]";
	}


	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getProvince() {
		return province;
	}




	public void setProvince(String province) {
		this.province = province;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public Address2() {
		// TODO Auto-generated constructor stub
	}


	@Override
	protected Address2 clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Address2 address2 =null;
		try{
			address2 = (Address2)super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return address2;
	}
	
	

}
