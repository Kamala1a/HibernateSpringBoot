package ArrayListExamples;

import java.util.ArrayList;
import java.util.List;

public class CreateArrayListFromCollectionExample {
	public static void main(String args[]) {
		List<Integer> firstFivePrimeMembers = new ArrayList<>(); 
		firstFivePrimeMembers.add(2);
		firstFivePrimeMembers.add(3);
		firstFivePrimeMembers.add(5);
		firstFivePrimeMembers.add(7);
		firstFivePrimeMembers.add(11);
		
		List<Integer> firstTenPrimeMembers = new ArrayList<>(firstFivePrimeMembers);
		
		List<Integer> nextTenPrimeMembers = new ArrayList<>();
		nextTenPrimeMembers.add(13);
		nextTenPrimeMembers.add(17);
		nextTenPrimeMembers.add(19);
		nextTenPrimeMembers.add(23);
		nextTenPrimeMembers.add(29);
		
		firstTenPrimeMembers.addAll(nextTenPrimeMembers);
		
		System.out.println(firstTenPrimeMembers);
	}
}
