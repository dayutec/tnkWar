package DP6;

public  class clotheAb extends ConcreteCoponentPerson {
	
	protected ConcreteCoponentPerson Component;



	public void addClotheOp(ConcreteCoponentPerson Component ) {
		
		this.Component = Component;
		
	}


	public void show() {
		// TODO Auto-generated method stub
		if(Component != null){
			Component.show();	
		}
	}
	
	
}
