package java8.stream;

import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import java8.Lamda.Person;

public class StreamTest {
	
	public static void main(String args[]){
		
		Collection<Person> persons = new ArrayList<Person>();
		
		Person hong = new Person();
		hong.setBirthday(LocalDate.of(1981, 5, 16));
		hong.setEmailAddress("klykly@naver.com");
		hong.setGender(Person.Sex.MALE);
		hong.setName("klykly");
		persons.add(hong);
		
		Person yun = new Person();
		yun.setBirthday(LocalDate.of(1982, 1, 05));
		yun.setEmailAddress("hihisora@naver.com");
		yun.setGender(Person.Sex.FEMALE);
		yun.setName("hihisora");
		persons.add(yun);
		
		for( Person person : persons){
			System.out.println(person.getAge());
		}
		
		OptionalDouble avgOpt = persons.stream().filter(x -> x.getAge() > 30)
								.mapToDouble(x -> x.getAge())
								.average();
		
		System.out.println(avgOpt);
		
		Files temp = null;
		Stream<String> temp2;
		
	}

}
