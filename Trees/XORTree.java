//XORTree
import java.io.*;
import java.util.*;
public class XORTree{
static int t,n;
static int[] initial,goal;
static ArrayList<Integer> adj[];
static StringBuilder ans=new StringBuilder();
static ArrayList<Integer> nodes=new ArrayList<>();
static void dfs(int root,int par,int even,int odd,int lvl){
	int curr_val;
	// System.out.println(root+":"+even+":"+odd+":"+lvl);
	//even level
	if((lvl&1)==0){
		curr_val=(initial[root]+even)%2;		
		if(curr_val!=goal[root]){
			even++;
			nodes.add(root);
		}
	}	
	else{
		curr_val=(initial[root]+odd)%2;
		
		if(curr_val!=goal[root]){
			odd++;
			nodes.add(root);
		}
	}
	for(Integer x:adj[root]){
		if(x!=par){
			dfs(x,root,even,odd,(lvl+1)%2);
		}
	}
}
public static void solve(){
	dfs(1,-1,0,0,1);
	int size=nodes.size();
	System.out.println(size);
	for(int i=0;i<size;i++){
		System.out.println(nodes.get(i));
	}
}
XORTree(int n){
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
	 		initial=new int[n+1];
	 		goal=new int[n+1];
	 		XORTree t=new XORTree(n);
	 		for(int i=1;i<=n-1;i++){
	 			String[] str=br.readLine().split(" ");
	 			int u=Integer.parseInt(str[0]);
	 			int v=Integer.parseInt(str[1]);
	 			adj[u].add(v);
	 			adj[v].add(u);
	 		}
	 		String str[]=br.readLine().split(" ");
	 		for(int i=1;i<=n;i++){
	 			initial[i]=Integer.parseInt(str[i-1]);
	 		}
	 		str=br.readLine().split(" ");
	 		for(int i=1;i<=n;i++){
	 			goal[i]=Integer.parseInt(str[i-1]);
	 		}
	 		solve();
	 		ans.append("\n");
	 	}	 	
		 System.out.println(ans.toString());

    }
}