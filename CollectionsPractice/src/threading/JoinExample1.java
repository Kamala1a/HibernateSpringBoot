package threading;

public class JoinExample1 extends Thread{

	public void run() {
		
		for(int i = 1; i <= 4; i++) {
			
			try {
				Thread.sleep(400);
			} catch(Exception ex) {
				System.out.println(ex);
			}
			System.out.println(i);
			
		}
		
	}
	
	public static void main(String args[])  {
		JoinExample1 t1 = new JoinExample1();
		JoinExample1 t2 = new JoinExample1();
		JoinExample1 t3 = new JoinExample1();
		
		t1.start();
		try {
			t1.join();
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		t2.start();
		t3.start();
	}
	
}
