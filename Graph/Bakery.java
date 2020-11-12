//Bakery
//https://codeforces.com/problemset/problem/707/B
import java.io.*;
import java.util.*;
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;
		s=y;
	}
}
public class Bakery{
static int t,n,m,k;
static int[] ok;
static ArrayList<Pair> adj[];
static ArrayList<Integer> storage=new ArrayList<>();
static StringBuilder ans=new StringBuilder();
static Long maxl=Long.MAX_VALUE;
static Long minl=Long.MIN_VALUE;
public static long solve(){
	long ans=maxl;
	for(Integer x:storage){
		for(Pair nbrs:adj[x]){	
			if(ok[nbrs.f]!=1)		
			ans=Math.min(ans,nbrs.s);
		}
	}
	if(ans==maxl){
		return -1;
	}
	return ans;
}
Bakery(int n){
	adj=new ArrayList[n+1];
	for(int i=1;i<=n;i++){
		adj[i]=new ArrayList<>();
	}
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
	 		ok=new int[n+1];
	 		Bakery b=new Bakery(n);
	 		m=Integer.parseInt(str[1]);
	 		k=Integer.parseInt(str[2]);
	 		for(int i=1;i<=m;i++){
	 			str=br.readLine().split(" ");
	 			int u=Integer.parseInt(str[0]);
	 			int v=Integer.parseInt(str[1]);
	 			int l=Integer.parseInt(str[2]);
	 			adj[u].add(new Pair(v,l));
	 			adj[v].add(new Pair(u,l));
	 		}
	 		if(k!=0)
	 		str=br.readLine().split(" ");

	 		for(int i=0;i<k;i++){
	 			int st=Integer.parseInt(str[i]);
	 			storage.add(st);
	 			ok[st]=1;
	 		}
	 		ans.append(solve()+"\n");
	 	}	 	
		 System.out.println(ans.toString());

    }
}