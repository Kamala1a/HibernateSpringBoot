package threading;

public class YeildExample1 extends Thread{

	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " inside Run ");
		}
	}
	
	public static void main(String args[]) {
		YeildExample1 t1 = new YeildExample1();
		YeildExample1 t2 = new YeildExample1();
		t1.start();
		t2.start();
		
		for(int i = 0; i < 3; i++) {
			t1.yield();
			System.out.println(Thread.currentThread().getName() + " inside Main");
		}
	}
	
}
