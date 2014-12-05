package Enum;
public class PowerSwitchMain {
        //
	public static void main(String[] args) {
		PowerSwitch powerSwitch = PowerSwitch.ON;
		displayByPowerSwitch(powerSwitch.opposite());		
	}
	
	public static void displayByPowerSwitch (PowerSwitch powerSwitch){
		if(powerSwitch == PowerSwitch.ON){
			System.out.println("전원을 on 합니다.");
		}else{
			System.out.println("전원을 off 합니다.");
		}
	}
}