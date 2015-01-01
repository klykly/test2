package templateCallback;

public class SomeSubject {
	
	public void changeState(int newState){
		internalChangeState(newState);
		notifyObserver();
	}

	protected void internalChangeState( int newState){
		System.out.println("Super Class call internalChangeState");
	}
	
	private void notifyObserver(){
		System.out.println("notifyObserver");
	}
}
