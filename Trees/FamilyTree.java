//FamilyTree
//https://www.codechef.com/problems/FAMTREE
import java.io.*;
import java.util.*;
class Pair{
	long f,s;
	Pair(long x,long y){
		f=x;
		s=y;
	}
}

class FamilyTree{
static int t,n;
static int[] arr;
static ArrayList<Integer> adj[];
static long ans;
 static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next()  { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
    }


FamilyTree(int n){
	arr=new int[n+1];
	adj=new ArrayList[n+1];
	for(int i=1;i<=n;i++){
		adj[i]=new ArrayList<>();
	}
}
static Pair dfs(int src,int par){
	long max=arr[src];
	long min=arr[src];
	for(Integer x:adj[src]){
		if(x==par){
			continue;
		}
		Pair rp=dfs(x,src);
		max=Math.max(max,rp.f);
		min=Math.min(min,rp.s);		
	}
	ans=Math.max(ans,Math.max(max-arr[src],arr[src]-min))	;
	return new Pair(max,min);
}
public static void main(String[] args) throws IOException{
		 FastReader f = new FastReader();
	 	
	 	n=f.nextInt();
	 	int root=1;
	 	FamilyTree t=new FamilyTree(n);	 	
	 	for(int i=1;i<=n;i++){
	 		arr[i]=f.nextInt();
	 	}
		for(int i=1;i<=n;i++){
	 		int par=f.nextInt();
	 		if(par==-1){
	 			root=i;
	 			continue;
	 		}
	 		adj[i].add(par);
	 		adj[par].add(i);
	 	}
	 	dfs(root,-1);
		System.out.println(ans);

    }
}
