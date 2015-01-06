package test;

public class FinallyTest {

	
	public static void main(String args[]){
		
		
		try{
			System.out.println("test1");
			System.exit(1);
		}finally{
			
			System.out.println("test2");
		}
	}
}
