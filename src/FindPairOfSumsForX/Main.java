package FindPairOfSumsForX;
import java.io.*;
import java.util.*;


public class Main {

	int[] arr;
	int len;
	int X;
    

    void read() throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String input[] = br.readLine().split(" ");
    	int i=0;
    	len = input.length;
    	arr = new int[len];
		while(i < len) {
			arr[i] = Integer.parseInt(input[i++]);
    	}
		X = Integer.parseInt(br.readLine());
	}
    
    // for the actual process
	void process() {
		HashMap<Integer, Integer> hmap = new HashMap<Integer,Integer>();
		int i=0;
		
		// make a hashmap with input value and its index
		while(i<len) {
			hmap.put(arr[i], i);
			i++;
		}
		
		// find the pairs
		i=0;
		while(i<len) {
			if(hmap.containsKey(X-arr[i]) && hmap.get(X-arr[i])!=i){
				System.out.println("Pair " + (X-arr[i]) + " and " + arr[i] + " have sum " + X);
				hmap.remove(X-arr[i]);
				hmap.remove(arr[i]);
			}
			i++;
		}
        
    }
   
	public static void main(String args[]) throws IOException {
		Main m = new Main();
		m.read();
		m.process();
	}
}


