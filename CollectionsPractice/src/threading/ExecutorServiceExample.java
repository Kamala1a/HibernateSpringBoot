package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample extends Thread{

	public void run() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		executorService.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("Asynchronous task");
			}
			
		});
		
		executorService.shutdown();
	}
	
	public static void main(String arg[]) {
		ExecutorServiceExample t1 = new ExecutorServiceExample();
		t1.start();
	}
}
