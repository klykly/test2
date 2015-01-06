package coddingTest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;

public class LotaionArray {
	
	
	int rotaionArray [] = {3, 4, 5, 6, 7, 1, 2};
	int rotaionArray2 [] = {4, 5, 6, 7, 1, 2, 3};
	int rotaionArray3 [] = {1, 2, 3, 4, 5, 6, 7};
	
	
	@Test
	public void getMinValue(){
		assertEquals( 1,  getMinValue(rotaionArray));
		assertEquals( 1,  getMinValue(rotaionArray2));
		assertEquals( 1,  getMinValue(rotaionArray3));
	}
	
	@Test
	public void getMinIndex(){
		assertEquals( 5, getMinIndex(rotaionArray));
		assertEquals( 4, getMinIndex(rotaionArray2));
		assertEquals( 0, getMinIndex(rotaionArray3));
		
	}
	
	@Test
	public void getSelectedIndex(){
		assertEquals(1, getSelectIndexR(rotaionArray, 4));
		assertEquals(1, getSelectIndexR(rotaionArray2, 5));
		assertEquals(2, getSelectIndexR(rotaionArray2, 6));
		assertEquals(6, getSelectIndexR(rotaionArray2, 3));
	}

	
	/**
	 * 로테이션 배열 가정
	 * @param array
	 * @param key
	 * @return
	 */
	public int getSelectIndexR(int array[], int key){
		int low = 0;
		int high = array.length -1;	
		int minIndex = getMinIndex(array);
		if ( key > array[high] ){
			return getSelectIndex( Arrays.copyOfRange(array, low, minIndex), key);
		}else if ( key < array[high] ){
			return getSelectIndex( Arrays.copyOfRange(array, minIndex, high), key);
		}else{
			return high;
		}
		
	}
	/**
	 * 이진배열 가정
	 * @param array
	 * @param key
	 * @return
	 */
	public int getSelectIndex(int array[], int key){
		 int low = 0;
		 int high = array.length -1;
		 int mid;
		   while (low <= high) {
		        mid = (low + high) / 2;
		        if( array[mid] == key){
		        	return mid;
		        }
		        
		        if (array[mid] > key) {
				    high = mid - 1;
		        } else if (array[mid] < key) {
		        	 low = mid + 1;
		        } else {
		            return mid;
		        }
		    }
		return -1;
	}
	
	/**
	 * 로테이션 배열 가정
	 * @param array
	 * @return
	 */
	public int getMinIndex(int array[]){
		 int low = 0;
		 int high = array.length -1;
		 int mid;
		 int key = 1;
		   while (low <= high) {
		        mid = (low + high) / 2;
		        if( array[mid] == key){
		        	return mid;
		        }
		        
		        if (array[mid] > array[high]) {
				    low = mid + 1;
		        } else if (array[mid] < array[high]) {
				    high = mid - 1;
		        } else {
		            return mid;
		        }
		    }
		return -1;
	}
	
	public int getMinValue(int array[]){
		int arrayLength = array.length;
//		System.out.println(Arrays.toString(array));
//		System.out.println("arrayLength:"+ arrayLength + " array[arrayLength / 2 ]:" + array[arrayLength / 2 ] + " arrayLength/2:" + arrayLength/2 );
		
		if( arrayLength == 1){
//			System.out.println(arrayLength);
//			System.out.println(array[0]);
			return array[0];
		}else if ( array[arrayLength / 2 -1] > array[arrayLength-1]){
			return getMinValue( Arrays.copyOfRange(array, arrayLength/2, arrayLength));
		}else if(array[arrayLength/2 -1] < array[arrayLength-1]){
			return getMinValue( Arrays.copyOfRange(array, 0, arrayLength/2));
		}
		return -1;
	}

}
