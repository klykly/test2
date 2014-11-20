package java8.Lamda;

import java.time.LocalDate;
import java.util.Date;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    LocalDate nowDate = LocalDate.now();
    
    public int getAge() {
        return nowDate.getYear() - birthday.getYear();
    }

    public void printPerson() {
       System.out.println(this.toString());
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + birthday + ", gender="
				+ gender + ", emailAddress=" + emailAddress + "]";
	}
    
	
	public static void main(String args[]){
		
		Person p = new Person();
		LocalDate birthDate = LocalDate.of(1981,5,16);
		LocalDate nowDate = LocalDate.now();
		
		System.out.println(birthDate);
		System.out.println(nowDate);
		
		System.out.println(nowDate.getYear() - birthDate.getYear());
//		p.setBirthday(birthday);
	}
    
}