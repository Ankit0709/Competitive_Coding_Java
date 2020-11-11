//Reports
// /https://codeforces.com/problemset/problem/522/A
import java.io.*;
import java.util.*;
public class Reports{
static int t,n;
static int[] arr;
static HashMap<String,ArrayList<String>> adj=new HashMap<>(); 
static StringBuilder ans=new StringBuilder();
static long depth(String node,HashMap<String,Boolean> vis){
	long height=0;
	vis.put(node,true);
	// System.out.println(node+":"+adj.get(node));
	for(String nbrs:adj.get(node)){
		if(!vis.get(nbrs)){
			height=1+depth(nbrs,vis);
		}
	}
	return height;
}
public static long solve(){
	long max_height=1;
	Set<String> vertic=adj.keySet();	
	for(String x:vertic){		
			HashMap<String ,Boolean> vis=new HashMap<>();
			for(String nodes:vertic){
				vis.put(nodes,false);
			}
			long depth=1+depth(x,vis);
			max_height=Math.max(depth,max_height);
			// System.out.println(x+":"+depth);
		
	}
	return max_height;
}
public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=1;
	 	while(t--!=0){
	 		n=Integer.parseInt(br.readLine());
	 		for(int i=1;i<=n;i++){
	 			String[] str=br.readLine().split(" ");
	 			String child=str[0].toLowerCase();
	 			String par=str[2].toLowerCase();
	 			ArrayList<String> nbrs=adj.getOrDefault(child,new ArrayList<>());
	 			nbrs.add(par);
	 			adj.put(child,nbrs);
	 			if(!adj.containsKey(par))
	 			adj.put(par,new ArrayList<>());
	 		}
	 		ans.append(solve()+"\n");
	 	}	 	
		 System.out.println(ans.toString());

    }
}
