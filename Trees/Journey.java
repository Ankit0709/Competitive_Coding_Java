//Journey
//https://codeforces.com/contest/839/problem/C
import java.io.*;
import java.util.*;
public class Journey{
static int t,n;
static int[] arr;
static long[] dist;
static ArrayList<Integer> adj[];
static StringBuilder ans=new StringBuilder();
Journey(int n){
	adj=new ArrayList[n+1];
	for(int i=1;i<=n;i++){
		adj[i]=new ArrayList<>();
	}
}
static double dfs(int src,int par){
	double sum=0;
	for(Integer x:adj[src]){
		if(x!=par){
			sum+=dfs(x,src)+1;
		}
	}
	if(sum==0){
		return 0;
	}
	int count=1;
	if(par==-1)count=0;
	return sum/(adj[src].size()-count);

}

public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=1;
	 	while(t--!=0){
	 		n=Integer.parseInt(br.readLine());
	 		dist=new long[n+1];
	 		Journey j=new Journey(n);	 	
	 		for(int i=1;i<=n-1;i++){
	 			String str[]=br.readLine().split(" ");
	 			int u=Integer.parseInt(str[0]);
	 			int v=Integer.parseInt(str[1]);
	 			adj[u].add(v);
	 			adj[v].add(u);
	 		}
	 		System.out.println(String.format("%.20f",dfs(1,-1)));
	 	}	 	
		 System.out.println(ans.toString());

    }
}