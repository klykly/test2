package test;

public class test {

	public static void main(String args[]){
		
		
		for(int i = 0; i < 100; i++){
			
			
			
			System.out.println("i=" + i +" /3 = " +  i/3 );
			if ( i % 3 > 0){
				System.out.println("last length = " + (i/3 + i%3));
			}
		}
	}
}
