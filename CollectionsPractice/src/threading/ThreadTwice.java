package threading;

public class ThreadTwice extends Thread	{

	public static void main(String args[]) {
		
		ThreadTwice t1 = new ThreadTwice();
		
		try {
			t1.start();
		}catch(IllegalThreadStateException ex) {
			System.out.println("T1 First IllegalThreadStateException");
		}
		
		try {
			t1.start();
		}catch(IllegalThreadStateException ex) {
			System.out.println("T1 First IllegalThreadStateException");
		}
		
	}
	
	public void run() {
		System.out.println("Running...");
	}
	
}
