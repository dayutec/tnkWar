package sl03;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Pleas input a english words");
		String password =scan.nextLine();
		char[] array = password.toCharArray();
		for(int i=0;i<array.length;i++ )
		{
			array[i]=(char)(array[i]^20000);
		}
		scan.close();
		System.out.println("coded contents");
		System.out.println(new String(array));
	}

}
