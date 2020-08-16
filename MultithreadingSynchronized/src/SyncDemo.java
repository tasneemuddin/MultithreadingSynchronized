class Counter {
	private int counter;
	
	//'synchronized', Only one thread can access this method at a time
	public synchronized void increment() {
		this.counter++;
	}
	
	public int getCounter() {
		return this.counter;
	}
}


public class SyncDemo {

	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		
		//Thread incrementing the value of counter 1000 times
		Thread T1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++)
					c.increment();
			}
		});
		
		//Thread incrementing the value of counter 1000 times
		Thread T2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 1000; i++)
					c.increment();
			}
		});
		
		T1.start();///start the thread
		T2.start();///start the thread
		
		T1.join();//wait for thread to finish
		T2.join();//wait for thread to finish
		
		System.out.println("Count : "+c.getCounter());
	}
}