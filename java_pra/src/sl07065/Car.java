package sl07065;

public class Car {

	private String name;
	private double speed;
	
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + "]";
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
	
}
