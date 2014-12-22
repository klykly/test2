package templateCallback;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TemplateCallbackTest {

	Calculator calculator;
	
	@Before
	public void setup(){
		calculator = new Calculator();
	}
	
	@Test
	public void testSum(){
		int inputArgs[] = {1, 4, 5};
		assertThat( calculator.sum(inputArgs), is(10));
		inputArgs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertThat( calculator.sum(inputArgs), is(55));
	}
	
	@Test(expected=NullPointerException.class)
	public void checkNull(){
		int inputArgs[] = null;
		assertThat( calculator.sum(inputArgs), is(55));
	}
	
	@Test
	public void testMultipliyer(){
		int inputArgs[] = {1, 4, 5};
		assertThat( calculator.multiplier(inputArgs), is(20));
		inputArgs = new int []{1, -4, 5};
		assertThat( calculator.multiplier(inputArgs), is(-20));
		inputArgs = new int []{1, -4, -5};
		assertThat( calculator.multiplier(inputArgs), is(20));
	}
}
