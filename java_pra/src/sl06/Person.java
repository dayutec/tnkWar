/**
 * 
 */
package sl06;

/**
 * @author eyuuyee
 *
 */
public class Person {

	private static int counter = 0;
	/**
	 * 
	 */
	public Person(String title) {
		// TODO Auto-generated constructor stub
		System.out.println("sold book :"+ title);
		counter++;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Person.counter = counter;
	}

	
}
