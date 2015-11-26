package DP01;



public class OperFactory {
	
	
		public static Oper2 createOperation(String oper)
		{
			Oper2 operx = null;
			switch(oper)
			{
				case "+":
					operx = new OperAdd();
					break;
				case "-":
					operx = new OperSub();
					break;	
				
			}
			return operx;
		}
}
