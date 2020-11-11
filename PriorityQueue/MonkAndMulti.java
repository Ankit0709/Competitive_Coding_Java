//MonkAndMulti
//https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/monk-and-multiplication/
import java.io.*;
import java.util.*;
public class MonkAndMulti{
static int t,n;
static int[] arr;
static StringBuilder ans=new StringBuilder();

public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=1;
	 	long prod=1;
	 	while(t--!=0){
	 		n=Integer.parseInt(br.readLine());
	 		arr=new int[n];
	 		String str[]=br.readLine().split(" ");
	 		//min heap build 
	 		PriorityQueue<Integer> heap=new PriorityQueue<>();
	 		for(int i=0;i<n;i++){
	 			arr[i]=Integer.parseInt(str[i]);
	 			if(i<2){
	 				ans.append("-1").append("\n");
	 				heap.add(arr[i]);
	 				prod*=arr[i];
	 				continue;
	 			}
	 			if(heap.size()==3){
	 				if(heap.peek()<arr[i]){
	 					int ele=heap.poll();
	 					prod/=ele;
	 					heap.add(arr[i]);
	 					prod*=arr[i];
	 				}
	 			}
	 			else{
	 				heap.add(arr[i]);
	 				prod*=arr[i];
	 			}
	 			ans.append(prod).append("\n");
	 		}	 		
	 	}	 	
		 System.out.println(ans.toString());

    }
}