package sl07065;

import java.awt.Point;

public class GPSCar extends Car implements GPS {

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		
		Point point = new Point();
		point.setLocation(super.getSpeed(), super.getSpeed());
		return point;
	}
	
    
	@Override
	public String toString() {
		return "[name=" + this.getName() + ", speed=" + this.getSpeed() + "]"+"GPSCar [ Location ("+getLocation().x+","+getLocation().y+" )]";
	
	}

	
	
	
	
}
