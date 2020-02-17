package threading;

public class CurrentThreadExample1 extends Thread{

	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String args[]) {
		
		CurrentThreadExample1 t1 = new CurrentThreadExample1();
		CurrentThreadExample1 t2 = new CurrentThreadExample1();
		
		t1.start();
		t2.start();
		
	}
	
}
