package sl06;

import java.awt.Color;

public class Cat {

	private String name;
	private int age;
	private double weight;
	private Color color;
	
	
	public Cat(String name, int age, double weight, Color color) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(getClass()!=obj.getClass()){
			return false;
		}
		Cat cat = (Cat)obj;
		
		return name.equals(cat.name)&&(age==cat.age)&&(weight==cat.weight)&&(color.equals(cat.color));
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("name"+name+"\n");
		sb.append("Age"+age+"\n");
		sb.append("Weight"+weight+"\n");
		sb.append("Color"+color+"\n");
		
		return sb.toString();
	}


	

}
