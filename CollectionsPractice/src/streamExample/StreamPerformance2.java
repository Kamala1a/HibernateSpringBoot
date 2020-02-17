package streamExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamPerformance2 {
	
	public static void main(String args[]) {
		
		List<String> myList = new ArrayList<String>();
		
		for(int i = 0; i < 1000000; i++) {
			myList.add("a"+i);
		}
		
		for(int i = 1000000; i < 2000000; i++) {
			myList.add("b"+i);
		}
		
		for(int i = 2000000; i < 3000000; i++) {
			
			myList.add("c"+i);
		}

		for(int i = 3000000; i < 4000000; i++) {
			myList.add("d"+i);
		}
		
		for(int i = 4000000; i < 5000000; i++) {
			myList.add("e"+i);
		}
		
		myList
			.stream()
			.filter(s -> s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
	}
}
