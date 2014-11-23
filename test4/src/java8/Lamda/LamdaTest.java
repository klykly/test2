package java8.Lamda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LamdaTest {
	
	public static void printPersonsOlderThan(List<Person> roster, int age) {
	    for (Person p : roster) {
	        if (p.getAge() >= age) {
	            p.printPerson();
	        }
	    }
	}
	
	
	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		    for (Person p : roster) {
		        if (low <= p.getAge() && p.getAge() < high) {
		            p.printPerson();
		        }
		    }
		}
	
	
	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}
	
	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) 
	{
		    for (Person p : roster) {
		        if (tester.test(p)) {
		            p.printPerson();
		        }
		    }
	}
	
	public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
		        for (Person p : roster) {
		            if (tester.test(p)) {
		                block.accept(p);
		            }
		        }
		}
	
	
	public static void processPersonsWithFunction( List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
		    for (Person p : roster) {
		        if (tester.test(p)) {
		            String data = mapper.apply(p);
		            block.accept(data);
		        }
		    }
		}

	public static void main(String args[]){
		
		
		List<Person> roster = new ArrayList<Person>();
		Person hong = new Person();
		hong.setBirthday(LocalDate.of(1981, 5, 16));
		hong.setEmailAddress("klykly@naver.com");
		hong.setGender(Person.Sex.MALE);
		hong.setName("klykly");
		roster.add(hong);
		
		Person yun = new Person();
		yun.setBirthday(LocalDate.of(1983, 1, 05));
		yun.setEmailAddress("hihisora@naver.com");
		yun.setGender(Person.Sex.FEMALE);
		yun.setName("hihisora");
		roster.add(yun);
//		printPersonsOlderThan(roster, 32);
		
//		printPersonsWithinAgeRange(roster, 10, 32);
		
//		printPersons(
//			    roster, new CheckPersonEligibleForSelectiveService());
		
//		printPersons(roster, new CheckPerson() {
//			@Override
//		    public boolean test(Person p) {
//		        return p.gender == Person.Sex.MALE &&
//		            p.getAge() >= 18 &&
//		            p.getAge() <= 35;
//		    }
//		});
		
		
//		printPersons(
//			    roster,
//			    (Person p) -> p.getGender() == Person.Sex.MALE
//			        && p.getAge() >= 18
//			        && p.getAge() <= 35
//			);
//		
//		
//		
//		printPersonsWithPredicate(
//			    roster,
//			    p -> p.getGender() == Person.Sex.MALE
//			        && p.getAge() >= 18
//			        && p.getAge() <= 25
//			);
//	
//
//		processPersons(
//			     roster,
//			     p -> p.getGender() == Person.Sex.MALE
//			         && p.getAge() >= 18
//			         && p.getAge() <= 25,
//			     p -> p.printPerson()
//			);
//		
//	
		
		
		processPersonsWithFunction(
			    roster,
			    p -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 35,
			    p -> p.getEmailAddress(),
			    em -> System.out.println(em)
			);
		
		
		
	}
}
