package sl06057;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Before Serial: ");
		Address ad = new Address("cn","sh","sh");
		Employee em1 = new Employee("Alex",30,ad);
		System.out.println("Infor of em1 ");
		System.out.println("em1 "+em1);
		System.out.println("After  Serial: ");
		
		ObjectInputStream in =null;
		ObjectOutputStream out =null;
		Employee em2= null;
		
		try {
			out= new ObjectOutputStream(new FileOutputStream("employee.dat"));
			out.writeObject(em1);
			in = new ObjectInputStream(new FileInputStream("employee.dat"));
			em2=(Employee)in.readObject();
			
		} catch (FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (em2!=null)
		{
		System.out.println("Infor em2 "+em2);
		em2.getAddress().setState("CN");
		em2.getAddress().setProvince("FJ");
		em2.getAddress().setCity("XM");
		em2.setName("Jimi");
		em2.setAge(32);
		System.out.println("Infor em1 "+em1);
		System.out.println("Infor em2 "+em2);
		}
	}

}
