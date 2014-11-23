package java8.stream;

import java.util.Random;

class Log{
	
	int getStatusCode(){
		return 200;
	}

	public int getResponseTime() {
		// TODO Auto-generated method stub
		int returnValue = new Random().nextInt(1000);
		System.out.println(returnValue);
		return returnValue;
	}
}
