//TimofeyAndTree
//https://codeforces.com/problemset/problem/763/A
import java.io.*;
import java.util.*;
public class TimofeyAndTree{
static int t,n;
static int u,v;
static int[] col;
static ArrayList<Integer> adj[];
static StringBuilder ans=new StringBuilder();
static boolean ok=false;
static void dfs(int node,int par,int color){
	ok=ok&&(col[node]==color);
	for(Integer  nbrs:adj[node]){
		if(nbrs!=par){
			dfs(nbrs,node,color);
		}
	}
	
}
public static boolean solve(int root){	
	boolean ans=true;
	for(Integer x:adj[root]){
		ok=true;
		int color=col[x];
		dfs(x,root,color);
		ans=ans&&ok;
	}
	return ans;	
}
TimofeyAndTree(int n){
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
	 		n=Integer.parseInt(br.readLine());
	 		col=new int[n+1];
	 		TimofeyAndTree t=new TimofeyAndTree(n);
	 		for(int i=1;i<=n-1;i++){
	 			String[] str=br.readLine().split(" ");
	 			u=Integer.parseInt(str[0]);
	 			v=Integer.parseInt(str[1]);
	 			adj[u].add(v);
	 			adj[v].add(u);
	 		}
	 		String str[]=br.readLine().split(" ");
	 		for(int i=0;i<n;i++){
	 			col[i+1]=Integer.parseInt(str[i]);
	 		}
	 		int root1=-1,root2=-1;
	 		for(int i=1;i<=n;i++){
	 			for(Integer x:adj[i]){
	 				if(col[x]!=col[i]){
	 					root1=x;
	 					root2=i;

	 				}
	 			}
	 		}
	 		// System.out.println(root1+":"+root2);
	 		if(root1==-1){
	 			ans.append("YES").append("\n");
	 			ans.append("1");

	 		}
	 		else{
	 			boolean ans1=solve(root1);
	 			boolean ans2=solve(root2);
	 			if(ans1){
	 				ans.append("YES").append("\n");
	 				ans.append(root1);
	 			}
	 			else if(ans2){
	 				ans.append("YES").append("\n");
	 				ans.append(root2);
	 			}
	 			else{
	 				ans.append("NO");
	 			}
	 		}

	 		ans.append("\n");
	 	}	 	
		 System.out.println(ans.toString());

    }
}