package sl03;

import java.util.Scanner;

public class VariableExchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan = new Scanner(System.in);
		System.out.println("input A");
		long A = scan.nextLong();
		System.out.println("input B");
		long B= scan.nextLong();
		System.out.println("A="+A+"\t+B="+B);
		System.out.println("swap A , B");
		A=A^B;
		B=B^A;
		A=A^B;
		System.out.println("A="+A+"\t+B="+B);
		scan.close();
		
	}

}
