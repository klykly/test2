package test;

public class Ec {
	
	private boolean sort(int offset, int length){
		
		assert offset < 0;
		assert offset > 0;
		assert offset == 0;
		return true;
	}
	public static void main(String args[]){
		Ec temp = new Ec();
		System.out.println(temp.sort(1, 1));
	}

}
