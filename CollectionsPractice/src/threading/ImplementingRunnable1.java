package threading;

public class ImplementingRunnable1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Running");
	}
	
	public static void main(String args[]) {
		ImplementingRunnable1 i1 = new ImplementingRunnable1();
		Thread t1 = new Thread(new ImplementingRunnable());
		t1.start();
	}

}
