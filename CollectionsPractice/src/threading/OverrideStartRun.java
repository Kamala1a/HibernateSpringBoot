package threading;

public class OverrideStartRun extends Thread{

	public static void main(String args[]) {
		OverrideStartRun t1 = new OverrideStartRun();
		t1.start();
	}
	
	@Override
	public void start() {
		System.out.println("Overrided Start Method");
		super.start();
	}
	
	@Override
	public void run() {
		System.out.println("Overrided Run Method");
	}
}
