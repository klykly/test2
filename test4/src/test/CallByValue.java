package test;
public class CallByValue {
 
   public static void main(String[] args){
 
     CallByValue cbv = new CallByValue();
     TargetClass tc = new TargetClass();
    
     tc.setText( new String("ó�� �Է� ���Դϴ�."));
      System.out.println( " ���� �� : "+ tc.getText()+" "+ tc.hashCode() );
 
     
      //�Ʒ� �ڵ忡�� tc������ �õ��մϴ�.
     cbv.changeObject(tc);
     Object temp = new Object();
     
     //���� ������ �����? tc�� ��ȭ�� ���ٸ� call by value���װ� 
     
     //��ȭ�� �ִٸ� call by reference�̰���.
     System.out.println( " ���� �� : "+ tc.getText()+" "+ tc.hashCode() );
   }
 
   public void changeObject( TargetClass obj){
     
//�Ѿ�� ���ڸ� null ó���մϴ�.
//     obj = null;'
	   obj.setText("����� �Է°��Դϴ�");
   }
   

 
}