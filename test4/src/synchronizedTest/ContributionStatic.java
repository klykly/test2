package synchronizedTest;

public class ContributionStatic {
	
	private static int amount  =0;
	private static final Object lock = new Object();
	public synchronized static void donate(){
//		synchronized (lock) {
			amount++;
//		}

		
	}

	public int getTotal(){
		return amount;
	}
	
}
