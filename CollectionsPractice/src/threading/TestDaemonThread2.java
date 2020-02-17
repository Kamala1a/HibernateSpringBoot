package threading;

public class TestDaemonThread2 extends Thread{

	public static void main(String args[]) {
		TestDaemonThread2 t1 = new TestDaemonThread2();
		TestDaemonThread2 t2 = new TestDaemonThread2();
		
		
		t1.start();
		t1.setDaemon(true);
		t2.start();
	}
	
	 public void run(){  
		 System.out.println("Name: "+Thread.currentThread().getName());  
		 System.out.println("Daemon: "+Thread.currentThread().isDaemon());  
	 }  
	
}
