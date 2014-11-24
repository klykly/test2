package java7.folkJoin;

import org.perf4j.StopWatch;

public class FibonacciProblem {

	public int n;

	public FibonacciProblem(int n) {
		this.n = n;
	}

	public long solve() {
		return fibonacci(n);
	}

	private long fibonacci(int n) {
		if (n <= 1)
			return n;
		else 
			return fibonacci(n-1) + fibonacci(n-2);
	}
	public static void main(String[] args) throws Exception {

		int n = 50;
		 StopWatch stopWatch = new StopWatch();   
		FibonacciProblem bigProblem = new FibonacciProblem(n); 

		long result = bigProblem.solve();   

		System.out.println("Computing Fib number: " + n);
		System.out.println("Computed Result: " + result);
		  stopWatch.stop();
		  System.out.println("Elapsed Time: " + stopWatch.getElapsedTime());

	}
}