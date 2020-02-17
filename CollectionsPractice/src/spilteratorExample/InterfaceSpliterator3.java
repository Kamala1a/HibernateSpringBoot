package spilteratorExample;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class InterfaceSpliterator3 {
	public static void main(String args[]) {
		List<String> progList = Arrays.asList("Java","C","C++","Python","javascript");
		Spliterator<String> splitr1 = progList.spliterator();
		Spliterator<String> splitr2 = splitr1.trySplit();
		splitr1.forEachRemaining(System.out::println);
		System.out.println("----------Traversing the next half of the spliterator------");  
		splitr2.forEachRemaining(System.out::println);
	}
}
