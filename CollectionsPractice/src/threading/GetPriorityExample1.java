package threading;

public class GetPriorityExample1 extends Thread{

	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String args[]) {
		GetPriorityExample1 t1 = new GetPriorityExample1();
		GetPriorityExample1 t2 = new GetPriorityExample1();
		
		t1.start();
		System.out.println("t1 thread piority: " + t1.getPriority());
		t2.start();
		System.out.println("t2 thread prioroty: " + t2.getPriority());
		
		
	}
	
}