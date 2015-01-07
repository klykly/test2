package coddingTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class Quetion1_4 {
	
	String array1 =  "a" ;
	String array2 =  "ab" ;
	String array3 =  "abc" ;
	String array4 =  "abcdef" ;
	String [] array = { "ab", "ba"};
	
	
	
	public String[] getResult2(String array, String add){
		String[] returnArray = new String [array.length()+1];
		
		for( int i = 0; i <= array.length(); i++){
			returnArray[i] = array.substring(0, i) + add + array.substring(i, array.length());
		}
		return returnArray;
	}
	public String[] getResult(String input){
		System.out.println("input:" + input);
		if( input.length() == 1){
			return new String[] { input };
		}else if ( input.length() == 2 ){
			return new String[] {  input.substring(0, 1)+ input.substring(1,2), input.substring(1,2)+input.substring(0, 1) };
		}else{
			String[] underStepResults = getResult(input.substring(0, input.length()-1));
			String[] result = new String[0];
			String[] tempResult = null;
			String[] tempResult2 = null;
			for ( String unserStepResult : underStepResults ){
				tempResult = getResult2( unserStepResult, input.substring(input.length()-1 ) );
				tempResult2 = result;
				result = new String[tempResult.length + result.length];
				System.arraycopy(tempResult2, 0, result, 0, tempResult2.length);
				System.arraycopy(tempResult, 0, result, tempResult2.length, tempResult.length);
//				System.out.println(  Arrays.toString( getResult2( unserStepResult, input.substring(input.length()-1 ) ) ) );
			}
//			String[] returnArray = new String [underStepResults.length()+1];
//			for( int i = 0; i <= underStepResults.length(); i++){
//				returnArray[i] = array.substring(0, i) + add + array.substring(i, array.length());
//			}
			
			System.out.println(Arrays.toString(result));
			return result;
		}
	}
	@Test
	public void check(){
		
		
//		assertEquals( "a", getResult(array1)[0]);
//		assertEquals( array[0], getResult(array2)[0]);
//		assertEquals( array[1], getResult(array2)[1]);		
	}
	
	@Test
	public void check2(){
//		assertTrue(getResult2( array2, "c").length == 3);
//		System.out.println( Arrays.toString(getResult2( array2, "c")) );
		
		
		getResult(array4);
		
	}

}

