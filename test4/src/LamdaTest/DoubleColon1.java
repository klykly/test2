package LamdaTest;
public class DoubleColon1 {
	static void go() {
		System.out.println("Double Colon :: go oraclejava community...");
	}
	public static void main(String[] args) {
		Runnable r1 = () -> System.out.println("람다식으로 run :: ");
		r1.run();
		
		//double colon 연산자를 람다식 대신,,,
                //go 메소드가 static 이므로... 클래스이름::메소드이름
                //만약 static이 아니면 객체참조변수::메소드이름
		Runnable r2 = DoubleColon1::go;
		r2.run();
	}
}