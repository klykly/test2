package test;

import java.util.*;

import org.junit.Test;
import org.springframework.test.AssertThrows;

import static org.junit.Assert.*;

public class ThreeStackTest {
	
	
	public static boolean isValid( String input ){
		if( "".equals(input)){
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		
		char[] inputArray = input.toCharArray();
		char stackOut;
		for( char inputChar : inputArray){
			if( inputChar == '[' || inputChar == '(' || inputChar == '{'){
				stack.push(inputChar);
			}else if (  inputChar == ']' || inputChar == ')' || inputChar == '}' ){
				stackOut = stack.pop();
				if( (stackOut == '['  && inputChar == ']') || 
					(stackOut == '('  && inputChar == ')') ||
					(stackOut == '{'  && inputChar == '}')	){
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	@Test 
	public void isValidThing(){
		String input = "[{()}()[]{}]";
		assertTrue(isValid(input));
		input = "!";
		assertFalse(isValid(input));
		input = "";
		assertTrue(isValid(input));
		
		input = "[!]";
		assertFalse(isValid(input));
	}
	
	public static void main(String args[]){
		String input = "[{()}()[]{}]";
		
		System.out.println(isValid(input));

	}


}
