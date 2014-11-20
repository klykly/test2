package test;
public class CallByValue {
 
   public static void main(String[] args){
 
     CallByValue cbv = new CallByValue();
     TargetClass tc = new TargetClass();
    
     tc.setText( new String("처음 입력 값입니다."));
      System.out.println( " 변경 전 : "+ tc.getText()+" "+ tc.hashCode() );
 
     
      //아래 코드에서 tc변경을 시도합니다.
     cbv.changeObject(tc);
     Object temp = new Object();
     
     //이후 내용을 찍어볼까요? tc에 변화가 없다면 call by value일테고 
     
     //변화가 있다면 call by reference이겠죠.
     System.out.println( " 변경 후 : "+ tc.getText()+" "+ tc.hashCode() );
   }
 
   public void changeObject( TargetClass obj){
     
//넘어온 인자를 null 처리합니다.
//     obj = null;'
	   obj.setText("변경된 입력값입니다");
   }
   

 
}