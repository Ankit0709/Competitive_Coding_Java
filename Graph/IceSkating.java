//IceSkating
//https://codeforces.com/problemset/problem/217/A
import java.io.*;
import java.util.*;
public class IceSkating{
static int t,n;
static int[] arr;
static ArrayList<Integer> adj[];
static int[] xi,yi,vis;
static StringBuilder ans=new StringBuilder();
static void dfs(int src){
	vis[src]=1;
	for(int j=0;j<n;j++){
		//it is reachable when they have same x or y coordinate
		if(vis[j]!=1&&(xi[src]==xi[j]||yi[src]==yi[j])){
			dfs(j);
		}
	}
}
public static long components(){
	long component=0;
	for(int i=0;i<n;i++){
		if(vis[i]!=1){
			dfs(i);
			component++;
		}
	}
	return component-1;
}
public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=1;
	 	while(t--!=0){
	 		n=Integer.parseInt(br.readLine());
	 		xi=new int[n];
	 		yi=new int[n];
	 		vis=new int[n];
	 		for(int i=0;i<n;i++){
	 			String str[]=br.readLine().split(" ");
	 			xi[i]=Integer.parseInt(str[0]);
	 			yi[i]=Integer.parseInt(str[1]);
	 		}
	 		ans.append(components()+"\n");
	 	}	 	
		 System.out.println(ans.toString());

    }
}