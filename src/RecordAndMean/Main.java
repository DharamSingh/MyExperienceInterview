package RecordAndMean;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Record {
	public int min;
	public int sec;
	public int value;
	
	public Record(int v, int m, int s){
		value = v;
		min = m;
		sec = s;
	}
}

public class Main {

	ArrayList<Record> arr = new ArrayList<Record>();
	int lastMinutes;
	int X;
    
	Record getRecord(String input[]) {
		int v = Integer.parseInt(((input[1].split("\\("))[1].split("\\)"))[0]);
		int m = Integer.parseInt((input[0].split("m")[0]));
		int s = input[0].contains("s") ? Integer.parseInt(((input[0].split("s")[0].split("m")[1]))) : 0;
		return (new Record(v,m,s));
	}
	
	Record getMeanRecord(String input[]) {
		int v = 0;
		int m = Integer.parseInt((input[0].split("m")[0]));
		int s = input[0].contains("s") ? Integer.parseInt(((input[0].split("s")[0].split("m")[1]))) : 0;
		return (new Record(v,m,s));
	}
	
	void removePrevious(int X, Record r) {
		Iterator<Record> it = arr.iterator();
		while(it.hasNext()) {
			Record temp = it.next(); 
			if((temp.min < (r.min-X)) || (temp.min == (r.min-X) && temp.sec < r.sec)) {
				it.remove();
			} 
		}
	}
	
	Double getMean() {
		Iterator<Record> it = arr.iterator();
		Double count = 0.0;
		while(it.hasNext()) {
			Record temp = it.next();
			count = count + temp.value;
		}
		return (count/arr.size());
	}
	void printarr() {
		Iterator<Record> it = arr.iterator();
		while(it.hasNext()) {
			Record temp = it.next();
			System.out.println(temp.value + " " + temp.min+"m "+ temp.sec+"s");
		}
		System.out.println();
	}
    void process() throws IOException{
    	X=4;
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String command;
    	String input[];
    	while(true) {
    		command = br.readLine();
    		input = command.split(" ");
    		if(input[1].matches("^record.*$")) {
    			Record r = getRecord(input);
    			arr.add(r);
    			removePrevious(X, r);
    		} else {
    			Record r = getMeanRecord(input);
    			removePrevious(X, r);
    			System.out.println(getMean());
    		}
    		printarr();
    	}
    	
	}
    
    
   
	public static void main(String args[]) throws IOException {
		Main m = new Main();
		m.process();
	}
}


