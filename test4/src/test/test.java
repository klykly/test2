package test;

import java.lang.annotation.Annotation;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class test {

	public static void main(String args[]){
		
		AtomicInteger temp = new AtomicInteger(0);
		
		Annotation[] annotations;

	    System.out.println("Annotations available on superclass are as follows:-");
		annotations = Transactional.class.getAnnotations();
		
		for(Annotation ann:annotations)
			System.out.println(ann.annotationType().getCanonicalName());
			  
		  System.out.println("=====================================================================");
			
		    System.out.println("Annotations available on subclass are as follows:-");
			annotations = Transactional.class.getAnnotations();
		    for(Annotation ann:annotations)
		      System.out.println(ann.annotationType().getCanonicalName());
	}
}
