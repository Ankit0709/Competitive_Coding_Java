//LCA
import java.io.*;
import java.util.*;
public class LCA{
static int t,n,u,v;
static int[] arr,par,depth;
static ArrayList<Integer> adj[];
static StringBuilder ans=new StringBuilder();

static void  dfs(int src,int par){
	depth[src]=depth[par]+1;
	for(Integer x:adj[src]){
		if(x!=par){
			dfs(x,src);
		}
	}
}
static void swap(int x,int y){
	int temp=x;
	x=y;
	y=temp;
}
//O(log n) per query
public static long lca(int u,int v){
	while(u!=v){
		if(depth[u]>depth[v]){
			int temp=u;
			u=v;
			v=temp;
			
		}
		v=par[v];
	}
	return u;
}
LCA(int n){
	adj=new ArrayList[n+1];
	for(int i=1;i<=n;i++){
		adj[i]=new ArrayList<>();
	}
}
public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new
       FileReader("sampleinp.txt"));
    	// BufferedReader br = new BufferedReader( 
       //                       new InputStreamReader(System.in)); 
	 	
	 	t=1;
	 	while(t--!=0){
	 		n=Integer.parseInt(br.readLine());
	 		par=new int[n+1];
			depth=new int[n+1];
	 		LCA t=new LCA(n);
	 		for(int i=1;i<=n-1;i++){
	 			String[] str=br.readLine().split(" ");
	 			u=Integer.parseInt(str[0]);
	 			v=Integer.parseInt(str[1]);
	 			adj[u].add(v);
	 			adj[v].add(u);
	 			par[v]=u;
	 		}
	 		depth[0]=-1;
	 		dfs(1,0);
	 		String[] str=br.readLine().split(" ");
	 		u=Integer.parseInt(str[0]);
	 		v=Integer.parseInt(str[1]);
	 		ans.append(lca(u,v)+"\n");
	 	}	 	
		System.out.println(ans.toString());

    }
}