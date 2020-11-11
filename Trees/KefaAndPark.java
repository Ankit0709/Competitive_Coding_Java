//KefaAndPark
//https://codeforces.com/problemset/problem/580/C
import java.io.*;
import java.util.*;
public class KefaAndPark{
static int t,n,m;
static int[] arr;
static int paths;
static ArrayList<Integer> adj[];

static StringBuilder ans=new StringBuilder();
KefaAndPark(int n){
    adj=new ArrayList[n+1];
    for(int i=1;i<=n;i++){
        adj[i]=new ArrayList<>();
    }
}
public static void dfs(int src,int par,int k){
    if(arr[src-1]==1){
        k--;
    }
    else{
        k=m;
    }
   
    if(k<0){
        return;
    }
    boolean leafhaiyanhi=true;
    for(Integer x:adj[src]){
        if(x!=par){
            leafhaiyanhi=false;            
            dfs(x,src,k);
        }
    }
    if(leafhaiyanhi){
        paths++;
    }
    return ;
}
public static void main(String[] args) throws IOException{
       //  BufferedReader br = new BufferedReader(new
       // FileReader("sampleinp.txt"));
        BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
        String str[]=br.readLine().split(" ");
         n=Integer.parseInt(str[0]);
         m=Integer.parseInt(str[1]);
         KefaAndPark x=new KefaAndPark(n);
         str=br.readLine().split(" ");
         arr=new int[n];
         for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
         }    
         for(int i=1;i<=n-1;i++){
             str=br.readLine().split(" ");
            int u=Integer.parseInt(str[0]);
            int v=Integer.parseInt(str[1]);
            adj[u].add(v);
            adj[v].add(u);
         }
         dfs(1,0,m);
         ans.append(paths);
         System.out.println(ans.toString());

    }
}