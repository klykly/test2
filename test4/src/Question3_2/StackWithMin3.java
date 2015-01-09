package Question3_2;

import java.util.Stack;

public class StackWithMin3 extends Stack<Integer> {
	
	private int minValue = 0;
	private int minCount = 0;
	//실패실패 배열로 하던가 해야함
	public void push(int value){
		if (value == minValue) {
			minCount++;
		}else if( value < minValue){
			minValue = value;
			minCount = 1;
		}else if( minValue == 0){
			minValue = value;
		}
		super.push(value);
	}

	public Integer pop(){
		int popValue = super.pop();
		if( popValue == minValue){
			minCount--;
		}
		
		
		
		return popValue;
	}
	
	public int min(){
		if (minValue == 0) {
			return Integer.MAX_VALUE;
		} else {
			return minValue;
		}
	}

}
