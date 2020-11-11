
//PRO
//https://www.spoj.com/problems/PRO/
import java.io.*;
import java.util.*;
public class PRO{
static int t,n;
static int[] arr;
static ArrayList<Integer> adj[];
static StringBuilder ans=new StringBuilder();
public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	t=Integer.parseInt(br.readLine());
	 	PriorityQueue<Integer> max_heap=new PriorityQueue<>(Collections.reverseOrder());
	 	PriorityQueue<Integer> min_heap=new PriorityQueue<>();
	 	long sum=0;
	 	while(t--!=0){
	 		String[] str=br.readLine().split(" ");
	 		n=Integer.parseInt(str[0]);

	 		for(int i=1;i<=n;i++){
	 			int ele=Integer.parseInt(str[i]);
	 			min_heap.add(ele);
	 			max_heap.add(ele);
	 		}
	 		sum+=max_heap.poll()-min_heap.poll();
	 		
	 	}	 	
		ans.append(sum);
		 System.out.println(ans.toString());

    }
}