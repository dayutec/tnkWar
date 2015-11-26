package DP02;

public class CashFactory {

	
	public static CashSuper createCashAccept(String type){
	CashSuper cs = null;
	
	switch(type)
	{
		case "Normal" :
			cs = new CashNormal();
			break;
		case "3R1" :
			cs = new CashReturn(300,100);
			break;
		case "D8" :
			cs = new CashRebate(0.8);
			break;
			
	}
	return cs;
	
	}
	
}
