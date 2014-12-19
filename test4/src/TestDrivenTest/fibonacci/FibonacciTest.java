package TestDrivenTest.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {
	
	static int fib(int n){
		if( n == 0 ) return 0; 
		else if ( n <= 2 ) return 1;
		return fib(n-1) + fib(n-2);
	}
	@Test
	public void testFibonacci(){
		int cases[][] = { {0,0}, {1,1}, {2,1}, {3,2}, {20,6765}	};
		for( int i = 0; i < cases.length; i++){
			assertEquals(cases[i][1], fib(cases[i][0]));
		}
	}

}
