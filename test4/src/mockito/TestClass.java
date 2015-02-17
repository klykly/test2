package mockito;
class TestClass{
	
	public String getName(){
		return "john";
	}
	
	public int getDouble(int value){
		System.out.println("call double:" + value);
		return value*2;
	}
	
	public int getDoubleDouble(int value){
		System.out.println("caoll doubledouble:" + value);
		return this.getDouble(value)*2;
	}
	
	public int getDoubleDoubleDouble(TestClass testClass, int value){
		return testClass.getDouble(value);
	}
}