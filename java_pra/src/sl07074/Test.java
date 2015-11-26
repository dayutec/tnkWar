package sl07074;

import java.lang.reflect.Field;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student student = new Student();
		Class<?> clazz = student.getClass();
		
		System.out.println("Name of the class  "+ clazz.getCanonicalName());
		
		try {
			Field id = clazz.getDeclaredField("id");
			System.out.println("Before Set ID class "+ student.getId());
			id.setAccessible(true);
			id.setInt(student, 10);
			System.out.println("After Set ID class "+ student.getId());
			
			Field name= clazz.getDeclaredField("name");
			System.out.println("Before Set Name "+ student.getName());
			name.setAccessible(true);
			name.set(student, "Alex");
			System.out.println("After Set Name  "+ student.getName());
			
			
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
