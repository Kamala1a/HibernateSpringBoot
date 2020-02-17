package threading;

public class SleepExample2 extends Thread{

	public void run() {
		
		for(int i = 1; i < 5; i++) {
			
			try {
				Thread.sleep(-500);
			} catch(InterruptedException ex) {
				System.out.println(ex);
			}
			
			System.out.println(i);
		}
	}
	
	public static void main(String args[]) {
		SleepExample2 s1 = new SleepExample2();
		SleepExample2 s2 = new SleepExample2();
		
		s1.start();
		s2.start();
	}
	
}