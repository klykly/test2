package java8;

public interface NamedPerson {
	String firstName();
	String lastName();
	
	
	default String fullName(){
		return firstName() + " " + lastName();
	}
}
