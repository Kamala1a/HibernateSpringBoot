package threading;

public class ImplementThreadWithRunnableRUN implements Runnable{

	@Override
	public void run() {
		System.out.println("Running....");
	}
	
	public static void main(String args[]) {
		Thread t1 = new Thread(new ImplementThreadWithRunnableRUN());
		t1.run();
		t1.run();
	}

}
