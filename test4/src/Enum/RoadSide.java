package Enum;
public enum RoadSide {
	//
	Left("����"),
	Right("������"); 
	
	private String krName;

	private RoadSide() {
		//
	} 
	
	private RoadSide(String krName) {
		this.krName = krName; 
	}
	
	public String getKrName() {
		return krName; 
	}
}