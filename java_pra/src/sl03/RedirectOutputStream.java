package sl03;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectOutputStream{	
	public static void main(String[] args){
	try{
		PrintStream out = System.out;
		PrintStream ps =new PrintStream("C:\\Users\\eyuuyee\\workspace\\java_pra\\log.txt");
		System.setOut(ps);
		int age=18;
		System.out.println("intial value is 18");
		String sex="Female";
		System.out.println("intial sex is Female");
		String infor ="this is "+sex+"child, and age is "+age;
		System.out.println("infor:"+ infor);
		System.setOut(out);
		System.out.println("program Done");
		
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	}	
}