package DP07;

public class proxy implements sendGift {

	hunter gg;
		
	public proxy(flower mm) {
		gg = new hunter(mm);
	}

	@Override
	public void giveGift() {
		// TODO Auto-generated method stub
		gg.giveGift();
	}

}
