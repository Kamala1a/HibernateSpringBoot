package threading;

public class IsAliveExample extends Thread{

	public void run() {
		try {
			Thread.sleep(300);
			System.out.println("is run() method isAlive: " + Thread.currentThread().isAlive());
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		IsAliveExample t1 = new IsAliveExample();
		System.out.println("Before Starting Thread is Alive: " + t1.isAlive());
		t1.start();
		System.out.println("After Starting Thread is Alive: " + t1.isAlive());
	}
	
}
