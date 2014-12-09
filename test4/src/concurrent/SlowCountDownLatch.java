package concurrent;
public class SlowCountDownLatch {
    private int count;
    public SlowCountDownLatch(int count) {
        if (count < 0)
            throw new IllegalArgumentException(count + " < 0");
        this.count = count;
    }

    public void await() {
        while (true) {
            synchronized(this) {
                if (count == 0) return;
            }
        }
    }

    public synchronized void countDown() {
        if (count != 0){
        	count--;
        	System.out.println(count);
        }
            
    }
    
    public static void main(String args[]){
    	
    	
    	SlowCountDownLatch slowCountDownLatch = new SlowCountDownLatch(1000);
    	
    	
    	
    	Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(slowCountDownLatch.count > 0){
					slowCountDownLatch.countDown();
				}
				
			}
		});
    	
//    	thread.setDaemon(true);;
    	thread.start();
    	slowCountDownLatch.await();
    	System.out.println("Finish!");
    }
}