package LamdaTest;
public class DoubleColon1 {
	static void go() {
		System.out.println("Double Colon :: go oraclejava community...");
	}
	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("���ٽ����� run :: ");
		r1.run();
		
		//double colon �����ڸ� ���ٽ� ���,,,
                //go �޼ҵ尡 static �̹Ƿ�... Ŭ�����̸�::�޼ҵ��̸�
                //���� static�� �ƴϸ� ��ü��������::�޼ҵ��̸�
		Runnable r2 = DoubleColon1::go;
		r2.run();
	}
}