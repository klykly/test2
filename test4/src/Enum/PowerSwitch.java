package Enum;
public enum PowerSwitch {
	ON("ÄÑÁü"),
	OFF("²¨Áü");
	
	private String krName;
	
	private PowerSwitch(){
	}

	private PowerSwitch(String krName){
		this.krName = krName;
	}
	
	public String getKrName(){
		return krName;
	}
	
	public PowerSwitch opposite() {
		if (this == PowerSwitch.ON) {
			return PowerSwitch.OFF;  
		} else {
			return PowerSwitch.ON; 
		}
	}
}