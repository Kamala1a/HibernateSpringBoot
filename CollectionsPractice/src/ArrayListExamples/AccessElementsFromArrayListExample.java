package ArrayListExamples;

import java.util.ArrayList;
import java.util.List;

public class AccessElementsFromArrayListExample {
	public static void main(String args[]) {
		List<String> topProgrammingLanguages = new ArrayList<>();
		
		if(topProgrammingLanguages.isEmpty()) {
			System.out.println("topProgrammingLanguages List is Empty");
		}
		
		topProgrammingLanguages.add("C");
		topProgrammingLanguages.add("Java");
		topProgrammingLanguages.add("C++");
		topProgrammingLanguages.add("Python");
		topProgrammingLanguages.add(".net");
		
		
	}
}
