package threading;

public class ExtendingThread1 extends Thread{

	public void run() {
		System.out.println("Its Running....");
	}
	
	public static void main(String args[]) {
		ExtendingThread1 t1 = new ExtendingThread1();
		t1.start();
		
	}
	
}
