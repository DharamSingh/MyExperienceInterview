package OnlineTest;
import java.io.*;
import java.util.*;

public class Expression {

	char inputString[] = new char[100];
    
    void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.read(inputString);
		
    }
    
    void result(char[] str1) {
    	HashMap<Character, Integer> array = new HashMap<Character, Integer>();
    	int c;
    	for(int i=0; i< str1.length; i++) {
    		c = array.containsKey(str1[i]) ? array.get(str1[i]) : 0;
    		array.put(str1[i], c+1); 
    	}
    	int k = 'a';
    	System.out.print("My string: " + k);
    }
	public static void main(String args[]) throws IOException {
		Expression t1 = new Expression();
		t1.readInput();
		
		t1.result(t1.inputString);
	}

}


