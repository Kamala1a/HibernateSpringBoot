package threading;

public class ThreadJoinExample1 extends Thread{

	public void run() {
		for(int i = 0; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch(Exception ex) {
				System.out.println(ex);
			}
			
		System.out.println(i);
		}
	}
	
	public static void main(String args[]) {
		ThreadJoinExample1 t1 = new ThreadJoinExample1();
		ThreadJoinExample1 t2 = new ThreadJoinExample1();
		ThreadJoinExample1 t3 = new ThreadJoinExample1();
		t1.start();
		try {
			t1.join();
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		t2.start();
		t3.start();
	}
	
}