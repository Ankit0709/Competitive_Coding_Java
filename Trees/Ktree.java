//Ktree
//https://codeforces.com/problemset/problem/431/C
import java.io.*;
import java.util.*;
public class Ktree{
static int t,n,k,d;
static int[] arr;
static int dp[][]=new int[105][2];
static int MOD=1000000007;
static StringBuilder ans=new StringBuilder();

public static long solve(){
	dp[0][0]=1;
	dp[0][1]=0;
	for(int i=1;i<=n;i++){

		dp[i][0]=0;dp[i][1]=0;

		for(int j=1;j<=k;j++){

			if(i-j<0) break;

			if(j<d){
				dp[i][0]=(dp[i][0]+dp[i-j][0])%MOD;
				dp[i][1]=(dp[i][1]+dp[i-j][1])%MOD;
			}
			else{
				dp[i][1]=(dp[i][1]+dp[i-j][0])%MOD;
				dp[i][1]=(dp[i][1]+dp[i-j][1])%MOD;
			}
		}
	}	
	
	return dp[n][1];
}
public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=1;
	 	while(t--!=0){
	 		String str[]=br.readLine().split(" ");
	 		n=Integer.parseInt(str[0]);
	 		k=Integer.parseInt(str[1]);
	 		d=Integer.parseInt(str[2]);
	 		ans.append(solve()+"\n");
	 	}	 	
		 System.out.println(ans.toString());

    }
}