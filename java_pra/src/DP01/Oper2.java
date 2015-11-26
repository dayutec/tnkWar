package DP01;

public class Oper2 {
	private double _numberA=0;
	private double _numberB=0;
	
	
	public double get_numberA() {
		return _numberA;
	}

	public void set_numberA(double _numberA) {
		this._numberA = _numberA;
	}


	public double get_numberB() {
		return _numberB;
	}

	public void set_numberB(double _numberB) {
		this._numberB = _numberB;
	}




	public  double GetResult()
	{
		double result = 0 ;
		return result;
	}
}

class OperAdd extends Oper2
{

	@Override
	public double GetResult() {
		// TODO Auto-generated method stub
		
		double result =0;
		result = this.get_numberA() + this.get_numberB();
		return result;
	}
	
  
}


class OperSub extends Oper2
{

	@Override
	public double GetResult() {
		// TODO Auto-generated method stub
		
		double result =0;
		result = this.get_numberA() - this.get_numberB();
		return result;
	}
	
  
}
