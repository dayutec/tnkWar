package DP02;

public class StrategyContext {

	StrategyCash sc;
	
	public StrategyContext(StrategyCash sc){
		
		this.sc = sc;
		
	}
	
	public void StrategyInterface(){
		
		sc.AlgorithmInterface();
		
	}
	
}
