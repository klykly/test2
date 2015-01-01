package templateCallback;

public class AnySubject extends SomeSubject{

	@Override
	protected void internalChangeState(int newValue){
//		super.internalChangeState(newValue);
		if(true){
			System.out.println("anySubject internalChangeState");
		}
	}
	
	
	public static void main(String args[]){
		AnySubject as = new AnySubject();
		as.changeState(1);
	}
}
