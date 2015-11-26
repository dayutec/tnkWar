package DP6;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConcreteCoponentPerson CP_Lee = new ConcreteCoponentPerson("Lee");
		addPants add_pants_Op = new addPants();
		addTshirt add_ts_Op = new addTshirt();
		
		add_pants_Op.addClotheOp(CP_Lee);
		add_ts_Op.addClotheOp(add_pants_Op);
		add_ts_Op.show();
		
		
	}

}
