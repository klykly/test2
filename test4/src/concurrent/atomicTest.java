package concurrent;

import java.util.concurrent.atomic.AtomicLong;

public class atomicTest {
	
	private static final AtomicLong nextSerialNum = new AtomicLong();
	
	public static long generateSerialNum(){
		return nextSerialNum.getAndIncrement();
	}
	
	
	public static void main(String args[]){
		
		
		Thread temp = new Thread( new Runnable() {
			
			@Override
			public void run() {
				System.out.println(generateSerialNum());
				
			}
		});
		while(true){
			System.out.println(generateSerialNum());
		}
		
		
	}

}
