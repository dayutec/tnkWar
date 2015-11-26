package sl06;

import java.awt.Color;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*Book book =new Book ("Java","me",13.11);
       System.out.println("Title: "+book.getTitle());
       System.out.println("AUthor: "+book.getAuthor());
       System.out.println("Price: "+book.getPrice());
       */
	  /*
	   System.out.println("Created Emperor 1: ");
	   Emperor emperor1 = Emperor.getInstance();
	   emperor1.getName();
	   System.out.println("Created Emperor 2: ");
	   Emperor emperor2 = Emperor.getInstance();
	   emperor2.getName();
	   System.out.println("Created Emperor 3: ");
	   Emperor emperor3 = Emperor.getInstance();
	   emperor3.getName();
	   System.out.println("Created Emperor 4: ");
	//   Emperor emperor4 = new Emperor();
	//   emperor4.getName();
	*/
	/*	
		String[] titles ={"java","c++","v++"};
		for(int i=0;i<5;i++)
		{
			new Person(titles[new Random().nextInt(3)]);
		}
		System.out.println("totle sold "+Person.getCounter()+" book");
	*/
		
		/*
		Cat cat1 = new Cat("java",12,21,Color.BLACK);
		Cat cat2 = new Cat("C++",12,21,Color.BLACK);
		Cat cat3 = new Cat("java",12,21,Color.BLACK);
		System.out.println("Cat1 "+ cat1);
		System.out.println("Cat2 "+ cat2);
		System.out.println("Cat3 "+ cat3);
		
		System.out.println("Cat1 & cat2 "+ cat1.equals(cat2));
		
		System.out.println("Cat1 & cat3 "+ cat1.equals(cat3));
	
         */
		
		/*
		System.out.println("Before Colon: ");
		Employee em1 = new Employee();
		em1.setName("Alex");
		em1.setAge(18);
		System.out.println("em1 "+em1);
		System.out.println("After  Colon: ");
		
		Employee em2 = em1;
		em2.setName("David");
		em2.setAge(26);
		System.out.println("Infor em1 "+em1);
		System.out.println("Infor em2 "+em2);
	*/
		
		/*
		System.out.println("Before Colon: ");
		Address ad = new Address("cn","sh","sh");
		Address_employee em1 = new Address_employee("Alex",30,ad);
		System.out.println("Infor of em1 ");
		System.out.println("em1 "+em1);
		System.out.println("After  Colon: ");
		
		Address_employee em2 = em1.clone();
		System.out.println("Infor em2 "+em2);
		em2.getAddress().setState("CN");
		em2.getAddress().setProvince("FJ");
		em2.getAddress().setCity("XM");
		em2.setName("Jimi");
		em2.setAge(32);
		System.out.println("Infor em1 "+em1);
		System.out.println("Infor em2 "+em2);
		
		*/
		
		
		
		System.out.println("Before Colon: ");
		Address2 ad = new Address2("cn","sh","sh");
		Address_employee2 em1 = new Address_employee2("Alex",30,ad);
		System.out.println("Infor of em1 ");
		System.out.println("em1 "+em1);
		System.out.println("After  Colon: ");
		
		Address_employee2 em2 = em1.clone();
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
