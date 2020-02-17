package streamExample;

import java.util.ArrayList;
import java.util.List;

public class StreamExample2 {
	public static void main(String args[]) {
		List<String> names = new ArrayList<String>();
		names.add("Kamala");
		names.add("Mahes");
		names.add("Uma");
		names.add("Malar");
		names.add("christina");
		names.add("Karunya");
		
		System.out.println("*********************Filter***********************");
		names.stream().filter((String name) -> name.length() >5).forEach(System.out::println);
		System.out.println("*********************Distinct***********************");
		names.stream().distinct().forEach(System.out::println);
		System.out.println("*********************Limit***********************");
		names.stream().limit(4).forEach(System.out::println);
		System.out.println("*********************SKIP***********************");
		names.stream().skip(4).forEach(System.out::println);
	}
}