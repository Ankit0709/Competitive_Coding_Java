//Dijikstra
//https://codeforces.com/problemset/problem/20/C
import java.io.*;
import java.util.*;
public class Dijikstra{
static int t,n,m;
static int[] par,dist;
static boolean [] vis;
static ArrayList<Pair> adj[];
static StringBuilder ans=new StringBuilder();
static Long maxl=Long.MAX_VALUE;
static Long minl=Long.MIN_VALUE;
static Integer max=Integer.MAX_VALUE;
static Integer min=Integer.MIN_VALUE;

public static boolean dijikstra(int src,int t){	
	PriorityQueue<Pair> q=new PriorityQueue<>((p1,p2)->{
		return p1.f-p2.f;
	});
	Arrays.fill(dist,max);
	dist[1]=0;
	par[1]=-1;
	vis[1]=true;

	q.add(new Pair(0,1));
	while(!q.isEmpty()){
		int u=q.poll().s;		
		if(u==t){
			return true;
		}
		vis[u]=true;

		for(Pair edge:adj[u]){
			int v=edge.f;
			int w=edge.s;
			//check if dist[u]+w<dist[v] then upddate its dist
			if(!vis[v]&&dist[u]+w<dist[v]){
				
				dist[v]=dist[u]+w;
				q.add(new Pair(dist[v],v));
				par[v]=u;
				

			}
			
		}
	}
	return false;
	

}
Dijikstra(int n){
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
	 		par=new int[n+1];
	 		dist=new int[n+1];
	 		vis=new boolean[n+1];
	 		Dijikstra t=new Dijikstra(n);
	 		m=Integer.parseInt(str[1]);
	 		for(int i=0;i<m;i++){
	 			str=br.readLine().split(" ");
	 			int u=Integer.parseInt(str[0]);
	 			int v=Integer.parseInt(str[1]);
	 			int w=Integer.parseInt(str[2]);
	 			adj[u].add(new Pair(v,w));
	 			adj[v].add(new Pair(u,w));	 			
	 		}
	 		if(dijikstra(1,n)){
	 			int x=n;
				LinkedList<Integer> path=new LinkedList<>();
				while(x!=-1){
					path.addFirst(x);
					x=par[x];
				}
				for(Integer ele:path){
					ans.append(ele).append(" ");
				}
	 		}
	 		else{
	 			ans.append("-1");
	 		}
	 		ans.append("\n");
	 	}	 	
		 System.out.println(ans.toString());

    }
}
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;
		s=y;
	}
	public String toString(){
		return "{"+f+":"+s+"}";
	}
}