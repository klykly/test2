package Enum;
public class PowerSwitchMain {
        //
	public static void main(String[] args) {
		PowerSwitch powerSwitch = PowerSwitch.ON;
		displayByPowerSwitch(powerSwitch.opposite());		
	}
	
	public static void displayByPowerSwitch (PowerSwitch powerSwitch){
		if(powerSwitch == PowerSwitch.ON){
			System.out.println("������ on �մϴ�.");
		}else{
			System.out.println("������ off �մϴ�.");
		}
	}
}