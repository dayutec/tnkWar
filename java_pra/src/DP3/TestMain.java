package DP3;

public class TestMain {

	//static int xxs;
	///int p;
	//p=0;
	int main;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long lng;
		lng = 0xFFFFFFFFFFL;
		
		System.out.println(lng);
		
		float ft;
		double dft;
		ft = 120.5f;
		System.out.println(ft);
		
		ft = 120.5E2f;
		System.out.println(ft);
		
		ft = 120.5E-2f;
		System.out.println(ft);
		
		
		dft = 120.5;
		System.out.println(dft);
		
		dft = 120.5E2;
		System.out.println(dft);
		
		dft = 120.5E-2;
		System.out.println(dft);
		
		boolean bn;
		bn= true;
		System.out.println(bn);
		bn=false;
		System.out.println(bn);

		int[][] a= new int [3][2];
		a[2][1] = 5;
		System.out.println(a[2][1]);
		
		short s = '0';
		
		Long lw = new Long(20);double d = 10.5; lw =(long)d;
		
		String sr = "hello";
		sr=sr+3;
		System.out.println(sr);
		
		int cnt =8;
	    boolean b[] = new boolean[3] ;
		b[2]=true;
	    if(b[0] && b[++cnt-7]) {
			cnt+=19;
		}
	    System.out.println(cnt);
	    
	    int xt =0,yt=0;int z =0;
	    for ( z=0; z<5;++z){
	    	if((++xt>2)&&(++yt>2)){
	    		xt++;
	    	}
	    //	 System.out.println(z);
	    }
	    System.out.println(z);
	    System.out.println(xt+" "+yt);
	    
	//    while(true){
	 //   System.out.println(xt+" "+yt);
	 //   }
	    
	    int xx=29;
	    switch (xx){
	    default : System.out.println(xx);
	    case 16:  System.out.println("16");
	    case 15:  System.out.println("15");
	    		  break;
	    case 1:  System.out.println("1");
		  break;	
		  	  
	    }
	    
	    
	 //   System.out.println(xxs);
	    
	  
	}

}
