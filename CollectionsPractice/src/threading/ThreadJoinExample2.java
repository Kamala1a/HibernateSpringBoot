package threading;

public class ThreadJoinExample2 extends Thread{
	static int i = 0;
	public void run() {
		i = i + 1;
		System.out.println("Running.....   " + i);
	}
	
	public static void main(String args[]) {
		ThreadJoinExample2 t1 = new ThreadJoinExample2();
		ThreadJoinExample2 t2 = new ThreadJoinExample2();
		ThreadJoinExample2 t3 = new ThreadJoinExample2();
		
		t1.start();
		t2.start();
		t3.start();
		
		t2.setName("Kamala");
		System.out.println("Name: " + t2.getName());
	}
	
}
