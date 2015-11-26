package sl04;

public class Diamond {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	  int i=0;
	  int j=0;
	  int len=7;
	  int wid=7;
	  int[][] arrayD = new int[len][wid];
	
	  
	  
	  int mid=len/2;
	  arrayD[0][mid]=1;
	  i=1;
	  while (i<wid)
	  {
		  
		  
		  //above half
		  if(i<=wid/2){ 
			  
			  arrayD[i][mid-i]=1;
			  arrayD[i][mid+i]=1;
			  
		  }//under half
		  else{
			  arrayD[i][i-mid]=1;
			  arrayD[i][len-1+mid-i]=1;
			  
		  }
		  
		  i++;
		 
		  
	  }
	  
	  for(i=0;i<wid;i++)
	  {
		  for(j=0;j<len;j++)
		  if (arrayD[i][j]==1)
		  {
			  System.out.print("*");
		  }
		  else
		  {
			  System.out.print(" "); 
		  }
		  System.out.println("");
	  }
		
		
	}
}
