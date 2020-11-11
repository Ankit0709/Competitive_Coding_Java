//RoyAndTrendTopic
//https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/roy-and-trending-topics-1/
import java.io.*;
import java.util.*;
class Pair{
	long f,s;
	Pair(long x,long y){
		f=x;
		s=y;
	}
	public String toString(){
		return "{"+f+" : "+s+"}";
	}
}
public class RoyAndTrendTopic{
static int t,n;
static long id,z,p,l,c,s;
static int[] arr;
static StringBuilder ans=new StringBuilder();

public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=1;
	 	while(t--!=0){
	 		//build min heap
	 		PriorityQueue<Pair> heap=new PriorityQueue<>((p1,p2)->{
	 			if(p1.f==p2.f){
	 				if(p1.s<p2.s){
	 					return -1;
	 				}
	 				else{
	 					return 1;
	 				}
	 			}
	 			else{
	 				if(p1.f<p2.f){
	 					return -1;
	 				}
	 				else{
	 					return 1;	
	 				}
	 			}
	 		});
	 		n=Integer.parseInt(br.readLine());
	 		HashMap<Long,Long> values=new HashMap<>();
	 		for(int i=1;i<=n;i++){
	 			String str[]=br.readLine().split(" ");
	 			id=Long.parseLong(str[0]);
	 			z=Long.parseLong(str[1]);
	 			p=Long.parseLong(str[2]);
	 			l=Long.parseLong(str[3]);
	 			c=Long.parseLong(str[4]);
	 			s=Long.parseLong(str[5]);
	 			values.put(id,z);
	 			long diff=(p*50+l*5+c*10+s*20)-z;
	 			if(i<=5){	 				
	 				heap.add(new Pair(diff,id));
	 			}
	 			else{

	 				Pair top=heap.peek();
	 				// System.out.println(top);
	 				if(top.f<diff){
	 					heap.poll();
	 					heap.add(new Pair(diff,id));
	 				}
	 				else if(top.f==diff){
	 					if(top.s<id){
	 						heap.poll();
	 						heap.add(new Pair(diff,id));
	 					}	
	 				}

	 			}
	 		}
	 		ArrayList<Pair> list=new ArrayList<>();
	 		while(!heap.isEmpty()){
	 			Pair rp=heap.poll();
	 			list.add(rp);
	 		}
	 		Collections.sort(list,(p1,p2)->{
	 			if(p1.f==p2.f){
	 				if(p2.s<p1.s){
	 					return -1;
	 				}
	 				else{
	 					return 1;
	 				}
	 			}
	 			else{
	 				if(p2.f<=p1.f){
	 					return -1;
	 				}
	 				else{
	 					return 1;
	 				}
	 			}
	 		});
	 		for(Pair x:list){
	 			System.out.println(x.s+" "+(x.f+values.get(x.s)));
	 		}
	 		
	 	}	 	
		 System.out.println(ans.toString());

    }
}