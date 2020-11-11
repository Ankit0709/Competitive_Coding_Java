//Party
//https://codeforces.com/problemset/problem/115/A
import java.io.*;
import java.util.*;
public class Party{
static int t,n;
static int[] arr;
static int[] par,lvl;
static boolean[] vis;
static ArrayList<Integer> adj[];

static StringBuilder ans=new StringBuilder();
Party(int n){
	adj=new ArrayList[n+1];
	for(int i=1;i<=n;i++){
 		adj[i]=new ArrayList<>();
 	}
}
public static void bfs(int src){
	lvl[src]=1;	
	Queue<Integer> q=new LinkedList<>();
	q.add(src);
	vis[src]=true;
	while(!q.isEmpty()){
		int rp=q.poll();
		for(Integer x:adj[rp]){
			if(!vis[x]){
				q.add(x);
				vis[x]=true;
				lvl[x]=lvl[rp]+1;
			}
		}
	}
}
public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	n=Integer.parseInt(br.readLine());
	 	par=new int[n+1];
	 	vis=new boolean[n+1];
	 	lvl=new int[n+1];
	 	Party p=new Party(n);
	 	for(int i=1;i<=n;i++){
	 		par[i]=Integer.parseInt(br.readLine());
	 		if(par[i]!=-1){
	 			adj[i].add(par[i]);
	 			adj[par[i]].add(i);
	 		}
	 	}
	 	for(int i=1;i<=n;i++){
	 		if(par[i]==-1){
	 			bfs(i);
	 		}
	 	} 	
	 	int max_lvl=0;
	 	for(int i=1;i<=n;i++){
	 		max_lvl=Math.max(max_lvl,lvl[i]);
	 	}
	 	System.out.println(max_lvl);
    }
}