package sl07065;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Defind Car:");
		Car car = new Car();
		car.setName("Adui");
		car.setSpeed(60);
		System.out.println(car);

		System.out.println("Defind GPSCar:");
		GPSCar gpsCar = new GPSCar();
		gpsCar.setName("Benz");
		gpsCar.setSpeed(60);
		System.out.println(gpsCar);
	}

}
