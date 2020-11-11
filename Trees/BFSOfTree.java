//BFSOfTree
import java.io.*;
import java.util.*;
public class BFSOfTree{
static int t,n,u,v;
static ArrayList<Integer> adj[];

BFSOfTree(int n){
	this.n=n;
	adj=new ArrayList[n+1];
	for(int i=1;i<=n;i++){
		adj[i]=new ArrayList<>();
	}
}
public static void  bfs(int src){
	Queue<Integer> q=new LinkedList<>();
	boolean[] vis=new boolean[n+1];
	q.add(src);
	vis[src]=true;
	while(!q.isEmpty()){
		int ele=q.poll();
		System.out.print(ele+" ");
		for(Integer x:adj[ele]){
			if(!vis[x]){
				q.add(x);
				vis[x]=true;
			}
		}
	}
}
public static void  bfs_level_wise(int src){
	Queue<Integer> q=new LinkedList<>();
	boolean[] vis=new boolean[n+1];
	q.add(src);
	vis[src]=true;
	while(!q.isEmpty()){
		int size=q.size();
		while(size--!=0){
			int ele=q.poll();
			System.out.print(ele+" ");
			for(Integer x:adj[ele]){
				if(!vis[x]){
					q.add(x);
					vis[x]=true;
				}
			}
			
		}
		System.out.println();	
		
	}
}
public static int  max_level_sum(int src){
	Queue<Integer> q=new LinkedList<>();
	boolean[] vis=new boolean[n+1];
	q.add(src);
	vis[src]=true;
	int max_sum=0;
	while(!q.isEmpty()){
		int size=q.size();
		int sum=0;
		while(size--!=0){
			int ele=q.poll();
			sum+=ele;
			for(Integer x:adj[ele]){
				if(!vis[x]){
					q.add(x);
					vis[x]=true;
				}
			}
			
		}
		max_sum=Math.max(max_sum,sum);
		
	}
	return max_sum;
}
public static void  closest_leaf_node(int root){
	Queue<Integer> q=new LinkedList<>();
	boolean[] vis=new boolean[n+1];
	int[] parent=new int[n+1];
	q.add(root);
	vis[root]=true;
	parent[root]=-1;
	int ans=-1;
	//find closest root
	while(!q.isEmpty()){
		int ele=q.poll();
		boolean flag=false;
		for(Integer nbrs:adj[ele]){
			if(vis[nbrs]){
				continue;
			}
			flag=true;
			q.add(nbrs);
			vis[nbrs]=true;
			parent[nbrs]=ele;
		}
		//means it is the root node
		if(!flag){
			ans=ele;
			break;
		}
	}
	while(ans!=-1){
		System.out.print(ans+" ");
		ans=parent[ans];
	}
}
public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new
       FileReader("sampleinp.txt"));
    	// BufferedReader br = new BufferedReader( 
       //                       new InputStreamReader(System.in)); 
	 	
	 	n=Integer.parseInt(br.readLine());
	 	BFSOfTree tree=new BFSOfTree(n);
	 	for(int i=1;i<=n-1;i++){
	 		String[] str=br.readLine().split(" ");
	 		u=Integer.parseInt(str[0]);
	 		v=Integer.parseInt(str[1]);
	 		adj[u].add(v);
	 		adj[v].add(u);
	 	}
	 	// bfs(1);
		// bfs_level_wise(1);
		closest_leaf_node(1);
	 	// System.out.println(closest_leaf_node(1));
		
	}
}