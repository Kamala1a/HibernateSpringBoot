package threading;

public class JoinExample2 implements Runnable{

	public void run() {
		for(int i = 1; i <= 4; i++) {
			try {
				Thread.sleep(1000);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
	public static void main(String args[]) {
		
		Thread t1 = new Thread(new JoinExample2());
		Thread t2 = new Thread(new JoinExample2());
		Thread t3 = new Thread(new JoinExample2());
		
		t1.start();
		try {
			t1.join();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		t2.start();
		t3.start();
	}
	
}
