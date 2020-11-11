//Haunted
//https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/haunted/description/
import java.io.*;
import java.util.*;
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;
		s=y;
	}
	public String toString(){
		return "{"+f+" : "+s+"}";
	}
}
public class Haunted{
static int q,k;
static int n,m;
static int t;
static int ele;
static int choice;
static long x,y;
static int[] arr;
static StringBuilder ans=new StringBuilder();
public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=1;
	 	while(t--!=0){
	 		String[] str=br.readLine().split(" ");
	 		n=Integer.parseInt(str[0]);
	 		m=Integer.parseInt(str[1]);
	 		HashMap<Integer,Integer> values=new HashMap<>();
	 		PriorityQueue<Pair> max_heap=new PriorityQueue<>((p1,p2)->{
	 			if(p1.f==p2.f){
	 				return p2.s-p1.s;
	 			}
	 			else{
	 				return p2.f-p1.f;
	 			}
	 		});	 		
	 		str=br.readLine().split(" ");
	 		for(int i=0;i<n;i++){
	 			ele=Integer.parseInt(str[i]);
	 			values.put(ele,values.getOrDefault(ele,0)+1);
	 			if(!max_heap.isEmpty()){
	 				Pair rp=max_heap.peek();
	 				if(rp.f<values.get(ele)){
	 					max_heap.add(new Pair(values.get(ele),ele));
	 				}
	 				else if(rp.f==values.get(ele)){
	 					if(rp.s<ele){
	 						max_heap.add(new Pair(values.get(ele),ele));
	 					}
	 				}

	 			}	
	 			else{
	 				max_heap.add(new Pair(values.get(ele),ele));
	 			}

	 			Pair top=max_heap.peek();
	 			// System.out.println(top);
	 			ans.append(top.s).append(" ").append(values.get(top.s));
	 			ans.append("\n");
	 			 			
	 		}
	 	}	 	
		 System.out.println(ans.toString());

    }
}