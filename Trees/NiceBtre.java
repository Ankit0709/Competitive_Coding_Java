//NiceBtre
//https://www.spoj.com/problems/NICEBTRE/
import java.io.*;
import java.util.*;
public class NiceBtre{
static int t,n;
static String str;
static int[] arr;
static long depth;
static StringBuilder ans=new StringBuilder();
static void solve(int pos,long height){
	if(pos>=str.length()){
		return;
	}
	
	if(depth<height){
		depth=height;
	}
	if(str.charAt(pos)=='n'){
		// System.out.println(height);
		solve(pos+1,height+1);
	}
	else{
		solve(pos+1,height);
	}
}
public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=Integer.parseInt(br.readLine());
	 	while(t--!=0){
	 		str=br.readLine();
	 		depth=0;
	 		solve(0,0);
	 		ans.append(depth);
	 		if(t!=0){
	 			ans.append("\n");
	 		}
	 	}	 	
		 System.out.println(ans.toString());

    }
}