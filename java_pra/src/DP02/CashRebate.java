package DP02;

public class CashRebate extends CashSuper {

	
	private double moneyRebate = 1d;
	
	public CashRebate(double moneyRebate) {
		
		this.moneyRebate =  moneyRebate ;
	}

	@Override
	public double acceptCash(double money) {
		// TODO Auto-generated method stub
		return money * moneyRebate;
	}

	
}
