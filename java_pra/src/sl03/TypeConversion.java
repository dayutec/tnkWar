package sl03;

public class TypeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b =127;
		char c='W';
		short s =23561;
		int i =3333;
		long l=400000L;
		float f=3.14159F;
		double d=54.523;
		
		//low to higher
		System.out.println("add byte: " + b);
		System.out.println("add char: " + (b+c));
		System.out.println("add short: "+(b+c+s));
		System.out.println("add int: "  +(b+c+s+i));
		System.out.println("add long: " + (b+c+s+i+l));
		System.out.println("add float: " + (b+c+s+i+l+f));
		System.out.println("add double: " + (b+c+s+i+l+f+d));
		
		//higher to low
		System.out.println("long to int " + (int)l);
		System.out.println("long to short " + (short)l);
		System.out.println("double to int " + (int)d);
		System.out.println("short to char " + (char)s);
	}

}
