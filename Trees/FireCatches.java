import java.io.*;
import java.util.*;
public class FireCatches{
static int t,n;
static int[] arr;
static StringBuilder ans=new StringBuilder();
public static long solve(){
	
}
public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new
       FileReader("sampleinp.txt"));
    	// BufferedReader br = new BufferedReader( 
       //                       new InputStreamReader(System.in)); 
	 	
	 	t=Integer.parseInt(br.readLine());
	 	while(t--!=0){
	 	n=Integer.parseInt(br.readLine());
	 	arr=new int[n];
	 		String str[]=br.readLine().split(" ");
	 		for(int i=0;i<n;i++){
	 			arr[i]=Integer.parseInt(str[i]);
	 		}
	 		ans.append(solve()+"\n");
	 	}	 	
		 System.out.println(ans.toString());

    }
}