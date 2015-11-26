package DP01;

public class Operateeer {

	public static int Ope(int A,int B,String Op)
	{
		switch(Op)
		{
			case "+": return A+B;
			
			case "-": return A-B;
			
			case "*": return A*B;
			
			case "/": 
			if (B != 0) 
			return A/B;
			else 
			return 0; 
							
		}
		return 0;
	}
	
}
