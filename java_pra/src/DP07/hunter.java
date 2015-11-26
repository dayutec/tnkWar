package DP07;

public class hunter implements sendGift{

	flower girl;
	
	public hunter(flower girl){
		this.girl = girl;
	}
	
	/*
	public void sendGift(){
		System.out.print(girl.name + "  a gift for you.");
	}
*/
	@Override
	public void giveGift() {
		// TODO Auto-generated method stub
		System.out.print(girl.name + "  a gift for you.");
	}
}
