package test;

import java.util.*;

public class ThreeStackTest {
	
	
	public static boolean isValid( String input){
		
		Stack<Character> stack = new Stack();
		
		char[] inputArray = input.toCharArray();
		char stackOut;
		for( char inputChar : inputArray){
			if( inputChar == '[' || inputChar == '(' || inputChar == '{'){
				stack.push(inputChar);
			}else{
				stackOut = stack.pop();
				if( (stackOut == '['  && inputChar == ']') || 
					(stackOut == '('  && inputChar == ')') ||
					(stackOut == '{'  && inputChar == '}')	){
				}else{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	
	public static void main(String args[]){
		String input = "[{()}()[]{}]";
		
		System.out.println(isValid(input));

	}


}
