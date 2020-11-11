//HotelVisit
//https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/hostel-visit/
import java.io.*;
import java.util.*;
public class HotelVisit{
static int q,k;
static int t;
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
	 		PriorityQueue<Long> max_heap=new PriorityQueue<>(Collections.reverseOrder());
	 		q=Integer.parseInt(str[0]);
	 		k=Integer.parseInt(str[1]);
	 		for(int i=1;i<=q;i++){
	 			str=br.readLine().split(" ");
	 			choice=Integer.parseInt(str[0]);
	 			if(choice==1){
	 				x=Long.parseLong(str[1]);
	 				y=Long.parseLong(str[2]);
	 				long dist=(x*x)+(y*y);
	 				if(i<=k){
	 					max_heap.add(dist);
	 				}
	 				else{
	 					if(dist<max_heap.peek()){
	 						max_heap.poll();
	 						max_heap.add(dist);
	 					}
	 				}
	 			}
	 			else{
	 				ans.append(max_heap.peek()+"\n");
	 			}
	 			
	 		}
	 	}	 	
		 System.out.println(ans.toString());

    }
}