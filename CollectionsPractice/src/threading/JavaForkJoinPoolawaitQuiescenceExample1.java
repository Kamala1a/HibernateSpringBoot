package threading;

import java.util.concurrent.ForkJoinPool;  
import java.util.concurrent.RecursiveTask;  
import java.util.concurrent.TimeUnit; 

public class JavaForkJoinPoolawaitQuiescenceExample1 {
	
	public static void main(String args[]) throws InterruptedException {
	
		int proc = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of Core available in your processor: " + proc);
		
		int[] n = {20, 23, 5, 6, 7, 8, 23, 12, 56, 1};
		ForkJoinPool pool = new ForkJoinPool(proc);
		Test t = new Test(n, 0, n.length);
		
		System.out.println("is Quiescent: " + pool.awaitQuiescence(2, TimeUnit.SECONDS));
		ForkJoinPool.commonPool().awaitQuiescence(2, TimeUnit.SECONDS);
		
		Integer r = pool.invoke(t);
		System.out.println("Pool.Invoke: " + r);
	}
	
}

class Test extends RecursiveTask<Integer> {

	int start;
	int end;
	int[] arr;
	
	Test(int[] arr, int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		if(start - end <= 10) {
			int sum = 0;
			for(int i = start; i < end; ++i) {
				sum += arr[i];
			}
			return sum;
		} else {
			int mid = start + (end - start) / 2;
			Test t1 = new Test(arr, start, mid);
			Test t2 = new Test(arr, start, mid);
			invokeAll(t1, t2);
			
			return (t1.join() + t2.join());
		}
	}
	
}