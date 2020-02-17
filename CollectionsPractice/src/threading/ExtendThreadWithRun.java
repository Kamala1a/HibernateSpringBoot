package threading;

public class ExtendThreadWithRun extends Thread{

	public void run() {
		System.out.println("Running....");
	}
	
	public static void main(String args[]) {
		ExtendThreadWithRun t1 = new ExtendThreadWithRun();
		t1.run();
	}
	
}
