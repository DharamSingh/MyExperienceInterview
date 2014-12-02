package OnlineTest;
import java.io.*;
import java.util.*;

// Comparator which implements the comparison logic
class CharComparator implements Comparator<Character> {

    Map<Character, Integer> map;
    public CharComparator(Map<Character, Integer> map) {
        this.map = map;
    }

    public int compare(Character a, Character b) {
    	if (map.get(a) > map.get(b)) {
        	return -1;
        } else if(map.get(a) == map.get(b)) {
        	return (a.compareTo(b)<0 ? -1 : 1);
        }
        else {
            return 1;
        }
    }
}

public class Frequency {

    public static void main(String[] args) throws IOException {

    	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        CharComparator cc =  new CharComparator(map); // this comparator will have the logic for character comparison required
        TreeMap<Character,Integer> sortedResult = new TreeMap<Character,Integer>(cc); // TreeMap will make the sorted list

        // take input
    	String input = new String();
        Scanner sc = new Scanner(System.in);
        input = sc.next();
		
        int count;
		int strLength = input.length(); // take length in a variable to avoid calling the length() function many times
		
		// calculate the occurrence count of each character
    	for(int i=0; i < strLength ; i++) {
    		count = map.containsKey(input.charAt(i)) ? map.get(input.charAt(i)) : 0;
    		map.put(input.charAt(i), (count+1)); 
    	}
    	// call the putAll() function to insert the map values into tree and apply comparator logic
    	sortedResult.putAll(map);
        
    	// finally get the result an print
    	Set<Character> s = sortedResult.keySet();
        Iterator<Character> it = s.iterator();
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
    }
}
