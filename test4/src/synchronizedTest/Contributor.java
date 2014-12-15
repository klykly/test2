package synchronizedTest;

public class Contributor extends Thread {

	private ContributionStatic myContribution;
	private String myName;
	public Contributor(ContributionStatic contirbution, String name){
		myContribution = contirbution;
		myName = name;
	}
	
	public void run(){
		for(int loop=0; loop<1000;loop++){
			myContribution.donate();
		}
		
		System.out.println( myName + " total = " + myContribution.getTotal());
	}
	
	public static void main(String args[])
	{
		Contributor[] crs = new Contributor[10];
		
		for(int loop=0; loop<10;loop++){
			ContributionStatic group = new ContributionStatic();
			crs[loop] = new Contributor(group, " Contributor" + loop);
		}
		
		for(int loop=0; loop < 10; loop++){
			crs[loop].start();
		}
	}
}
