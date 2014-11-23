package java8;

public class Student implements NamedPerson{
	private String fName, lName;
	
	
	public Student(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	@Override
	public String firstName() {
		return fName;
	}

	@Override
	public String lastName() {
		return lName;
	}

	public String fullName(){
		return fName + " : " + lName;
	}
	public static void main(String args[]){
		Student student = new Student("SUNGWOO", "HONG");
		
		System.out.println(student.fullName());
	}
}
