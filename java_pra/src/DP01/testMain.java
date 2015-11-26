package DP01;


import java.io.IOException;
import java.util.Scanner;



public class testMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner (System.in);
		System.out.println("Input number A please");
		int A = scan.nextInt();
		
		System.out.println("Input number B please");
		int B = scan.nextInt();
		System.out.println("Input OP A please:+ ,-, *, /. ");
		String OP = scan.next();
		
		System.out.println(A+"  "+B+"   "+OP.length());
		
			
		// Operateeer oper =new Operateeer();
		// int opResult = oper.Ope(A,B,OP);
		//System.out.println(opResult);
		
		Oper2 operx = null;
		operx = OperFactory.createOperation(OP);
		operx.set_numberA(A);
		operx.set_numberB(B);
		double result = operx.GetResult();
		System.out.println(result);
		
	}

}
