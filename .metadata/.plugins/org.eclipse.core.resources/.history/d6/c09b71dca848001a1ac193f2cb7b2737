package threading;

public class CurrentThreadExample2 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String args[]) {
		
		Thread t1 = new Thread(new CurrentThreadExample2());
		t1.start();
		t1.run();
	}
}
