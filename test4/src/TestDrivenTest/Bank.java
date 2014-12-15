package TestDrivenTest;

import java.util.Hashtable;

public class Bank {

	private Hashtable<Pair, Integer> rates = new Hashtable<Pair, Integer>();
	public Expression reduce(Expression source, String to) {
		return source.reduce(this, to);
	}

	public int rate(String from, String to) {
		if( from.equals(to)){
			return 1;
		}
		 Integer rate = ( Integer ) rates.get(new Pair(from, to));
		 return rate.intValue();
	}
	
	void addRate(String from, String to, int rate){
		rates.put(new Pair(from, to), new Integer(rate));
	}
	

}
