package sl04;

import java.math.BigDecimal;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BigDecimal sum = new BigDecimal(0.0);
		BigDecimal factorial = new BigDecimal(1.0);

		int i=1;
		
		while(i<=20)
		{
			sum=sum.add(factorial);
			//System.out.println(sum);
			++i;
		    factorial=factorial.multiply(new BigDecimal(1.0/i));
		}
		System.out.println("1+ 1/20!"+sum);
		
	}

}
