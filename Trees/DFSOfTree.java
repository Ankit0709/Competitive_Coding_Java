//DFSOfTree
import java.io.*;
import java.util.*;
public class DFSOfTree{
static int t,n,m,u,v;
static int[] lvl;
static int[] subtree;
static ArrayList<Integer> adj[];
DFSOfTree(int n){
	this.n=n;
	adj=new ArrayList[n+1];
	for(int i=1;i<=n;i++){
		adj[i]=new ArrayList<>();
	}
}
public static void dfs(int src,int par){
	
	for(Integer x:adj[src]){
		if(x==par){
			continue;
		}
		dfs(x,src);
	}
}
public static void dfs_level(int src,int par){	
	for(Integer x:adj[src]){
		if(x==par){
			continue;
		}
		lvl[x]=lvl[src]+1;
		dfs_level(x,src);
	}
}
public static void dfs_subtree(int src,int par){	
	subtree[src]=1;
	for(Integer x:adj[src]){
		if(x==par){
			continue;
		}
		dfs_subtree(x,src);
		subtree[src]+=subtree[x];
	}
	
}
public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new
       FileReader("sampleinp.txt"));
    	// BufferedReader br = new BufferedReader( 
       //                       new InputStreamReader(System.in)); 
	 	String str[]=br.readLine().split(" ");
	 	n=Integer.parseInt(str[0]);
	 	m=Integer.parseInt(str[1]);
	 	lvl=new int[n+1];
	 	subtree=new int[n+1];
	 	DFSOfTree tree=new DFSOfTree(n);
	 	for(int i=1;i<=m;i++){
	 		str=br.readLine().split(" ");
	 		u=Integer.parseInt(str[0]);
	 		v=Integer.parseInt(str[1]);
	 		adj[u].add(v);
	 		adj[v].add(u);
	 	}
	 	lvl[1]=1;
	 	// dfs(1,-1);
	 	// dfs_level(1,0);
	 	dfs_subtree(1,0);
	 	for(int i=1;i<=n;i++){
	 		System.out.println("Nodes in subtree of "+i+" is :"+subtree[i]);
	 	}
	 }
   
}