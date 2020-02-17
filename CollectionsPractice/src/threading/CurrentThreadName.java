package threading;

public class CurrentThreadName extends Thread{
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String args[]) {
		CurrentThreadName ctn1 = new CurrentThreadName();
		CurrentThreadName ctn2 = new CurrentThreadName();
		
		ctn1.start();
		ctn2.start();
	}
	
}
