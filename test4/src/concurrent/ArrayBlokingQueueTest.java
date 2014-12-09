package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlokingQueueTest {
	
	public static void main(String args[]) throws InterruptedException{
		
		
		ArrayBlockingQueue<String> temp = new ArrayBlockingQueue<String>(10);
		ArrayBlockingQueue<String> temp2 = new ArrayBlockingQueue<String>(200);

		
		temp.put("test1");
		temp.put("test2");
		temp.put("test3");
		temp.put("test4");
		temp.put("test5");
		temp.put("test6");
		
		
		System.out.println(temp.size());
		
		temp.drainTo(temp2);
		
		System.out.println(temp.size());
		System.out.println(temp2.size());
		
		System.out.println(temp2.poll());
		System.out.println(temp2.poll());
		System.out.println(temp2.poll());
		System.out.println(temp2.poll());
		
		
	}

}

