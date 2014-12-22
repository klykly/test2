package templateCallback;

public class Calculator {
	
	public int sum(int[] args){
		int startValue = 0;
		CalculatorCallBack callBack = new CalculatorCallBack() {
			@Override
			public int calculate( int x, int y) {
				return x + y;
			}
		};
		return calculateTemplet( startValue, callBack, args );
	}
	
	public int multiplier(int[] args){
		int startValue = 1;
		CalculatorCallBack callBack = new CalculatorCallBack() {
			@Override
			public int calculate( int x, int y) {
				return x * y;
			}
		};
		return calculateTemplet( startValue, callBack, args );
	}
	
	public int calculateTemplet(int startValue, CalculatorCallBack callBack, int[] args){
		int result = startValue;
		for(int i = 0; i < args.length; i++){
			result = callBack.calculate(result, args[i]);
		}
		return result;
	}
}
