package threading;

public class SleepExample1 extends Thread{

	public void run() {
		
		for(int i = 1; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch(InterruptedException ex) {
				System.out.println(ex);
			}
			System.out.println(i);
		}
		
	}
	
	public static void main(String args[]) {
		SleepExample1 s1 = new SleepExample1();
		SleepExample1 s2 = new SleepExample1();
		s1.start();
		s2.start();
	}
	
}
