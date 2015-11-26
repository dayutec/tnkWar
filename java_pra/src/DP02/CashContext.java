package DP02;

public class CashContext {

	private CashSuper cs;
	
	public CashContext(CashSuper csuper){
		
		this.cs = csuper;
		
	}
	
	public double GetResult(double money){
		
		return cs.acceptCash(money);
		
	}
}
