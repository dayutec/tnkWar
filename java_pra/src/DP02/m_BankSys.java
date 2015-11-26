package DP02;

import java.util.Scanner;

public class m_BankSys {

	private static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		double quatity = 0 ;
		double price = 0 ;
		double money =0 ;
		scan = new Scanner(System.in);
		System.out.println("show type : 1. Normal , 2. 3R1 , 3. OFF");
		String type = scan.next();
		System.out.println("Input Quatity:");
		quatity = scan.nextDouble();
		System.out.println("Input Price:");
		price = scan.nextDouble();
		
		
		CashSuper csuper = CashFactory.createCashAccept(type);
		money = quatity * price;
		System.out.println( csuper.acceptCash(money) );
		
		*/
		StrategyContext sContext;
		StrategyCash sCash;
		
		sContext = new StrategyContext(new ConcreteStrategyCashA() );
		sContext.StrategyInterface();
		
		
	}

}
