package spilteratorExample;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class InterfaceSpliterator1 {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(101);
		list.add(102);
		list.add(103);
		list.add(104);
		list.add(105);
		
		Stream<Integer> str = list.stream();
		
		Spliterator<Integer> splitr1 = list.spliterator();
		Spliterator<Integer> splitr2 = str.spliterator();
		
		System.out.println("Estimated Size: " + splitr1.estimateSize());
		System.out.println("Exact Size if known: " + splitr1.getExactSizeIfKnown());
		
		System.out.println("Characteritics: " + splitr1.characteristics());
		System.out.println("Has Characteritics: " + splitr1.hasCharacteristics(splitr1.characteristics()));
		
		System.out.println("Elements of ArrayList");
		
		splitr1.forEachRemaining((n) -> System.out.println(n));
		
		Spliterator<Integer> splitr3 = splitr2.trySplit();
		if(splitr3 != null) {
			System.out.println("Output from Splitr3");
			splitr3.forEachRemaining((n) -> System.out.println(n));
		}
		
		System.out.println("Output from Split2");
		if(splitr2 != null) {
			splitr2.forEachRemaining((n) -> System.out.println(n)); 
		}
	}
}
