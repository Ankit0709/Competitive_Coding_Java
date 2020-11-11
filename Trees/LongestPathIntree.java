//LongestPathIntree
//https://www.spoj.com/problems/PT07Z/
import java.io.*;
import java.util.*;
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;
		s=y;
	}
}
public class LongestPathIntree{
static int t,n;
static int[] arr;
static ArrayList<Integer> adj[];
static StringBuilder ans=new StringBuilder();
static Pair bfs(int src){
	Queue<Integer> q=new LinkedList<>();
	q.add(src);
	int[] dist=new int[n+1];
	Arrays.fill(dist,-1);
	dist[src]=0;
	while(!q.isEmpty()){
		int rp=q.poll();
		
		for(Integer x:adj[rp]){
			if(dist[x]==-1){
				q.add(x);
				dist[x]=dist[rp]+1;
			}
		}
	}
	int max_dist=0,node=0;
	for(int i=1;i<=n;i++){
		if(dist[i]>max_dist){
			max_dist=dist[i];
			node=i;
		}
	}
	return new Pair(node,max_dist);
}
public static long diameter(){
	Pair f1=bfs(1);
	Pair f2=bfs(f1.f);
	return f2.s;
}
LongestPathIntree(int n){
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
	 	
	 	n=Integer.parseInt(br.readLine());
	 	LongestPathIntree t=new LongestPathIntree(n);
	 	for(int i=1;i<=n-1;i++){
	 		String[] str=br.readLine().split(" ");
	 		int u=Integer.parseInt(str[0]);
	 		int v=Integer.parseInt(str[1]);
	 		adj[u].add(v);
	 		adj[v].add(u);
	 	}
	 	ans.append(diameter());
		System.out.println(ans.toString());
	 	}    
}