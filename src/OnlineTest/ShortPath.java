package OnlineTest;
import java.io.*;
import java.util.*;

class MyNode {
	public int a;
	public int b;
	public int time;
}

public class ShortPath {

	int[][] edge;
    int numberOfNodes;
    int cases;
    

    void read() throws IOException{
    	Scanner sc = new Scanner(System.in);
    	numberOfNodes = sc.nextInt();
    	edge = new int[numberOfNodes][numberOfNodes];
    	cases = sc.nextInt();
    }
    
    // for reading the input values
	void readInput() throws IOException {
		int xx[] = new int[10];
		int cc=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        for(int i =0 ; i<cases;i++) {
        	 
        	 String task = br.readLine();
        	 String []tasks = task.split(" ");
        	 int x = Integer.parseInt(tasks[1]);
    		 int y = Integer.parseInt(tasks[2]);
        	 if(tasks[0].equals("make")) {
        		 
        		 edge[x][y] = Integer.parseInt(tasks[3]);
        	 } else if (tasks[0].equals("check")){
        		 xx[cc++] = hasPath(x,y) ? 1 : 0;
        	 }
        }
    	System.out.println(cc);
        for(int j=0;j<cc;j++){
        	System.out.println(xx[j] == 1? "YES" : "NO");
        }
        
    }
    
	void walk(int orgin, Set<Integer> visited) {
	    for (int n = 1 ; n < numberOfNodes ;n++) {
	        if (!visited.contains(n)) {
	            visited.add(n);
	            walk(n, visited);
	        }
	    }
	}


	boolean hasPath(int origin, int target) {
	    Set<Integer> reachables = new HashSet<Integer>();
	    walk(origin, reachables);
	    return reachables.contains(target);
	}
   
	public static void main(String args[]) throws IOException {
		ShortPath m = new ShortPath();
		m.read();
		m.readInput();
		//m.result();
	}
}


