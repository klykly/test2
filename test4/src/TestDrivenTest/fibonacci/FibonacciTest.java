package TestDrivenTest.fibonacci;

import static org.junit.Assert.*;

import org.junit.*;

public class FibonacciTest {
	
	static int fib(int n){
		if( n == 0 ) return 0; 
		else if ( n <= 2 ) return 1;
		return fib(n-1) + fib(n-2);
	}
	
	@BeforeClass
	public static void start(){
		System.out.println("START----------------------------------------------");
	}
	@AfterClass
	public static void end(){
		System.out.println("END------------------------------------------------");
	}
	@Before
	public void setUp() {
		System.out.println("BEFORE!!");
	}
	@After
	public void after() {
		System.out.println("AFTER!!");
	}
	@Test
	public void testFibonacci(){
		int cases[][] = { {0,0}, {1,1}, {2,1}, {3,2}, {20,6765}	};
		for( int i = 0; i < cases.length; i++){
			assertEquals(cases[i][1], fib(cases[i][0]));
		}
	}
	@Test
	public void testFibonacci2(){
		int cases[][] = { {0,0}, {1,1}, {2,1}, {3,2}, {20,6765}	};
		for( int i = 0; i < cases.length; i++){
			assertEquals(cases[i][1], fib(cases[i][0]));
		}
	}
}
