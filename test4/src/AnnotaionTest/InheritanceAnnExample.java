package AnnotaionTest;
import java.lang.annotation.Annotation;

public class InheritanceAnnExample {
  public static void main(String[] args) {
    Annotation[] annotations;

    System.out.println("Annotations available on superclass are as follows:-");
	annotations = SuperClass.class.getAnnotations();
    for(Annotation ann:annotations)
      System.out.println(ann.annotationType().getCanonicalName());
  
    System.out.println("=====================================================================");
	
    System.out.println("Annotations available on subclass are as follows:-");
	annotations = SubClass.class.getAnnotations();
    for(Annotation ann:annotations)
      System.out.println(ann.annotationType().getCanonicalName());
  }
}

//@Description(data="SuperClass implementation")
//@InheritedDesc(data="Testing inheritance among annotations")
class SuperClass{
  void print(){
    System.out.println("Super class implementation");
  }
}

class SubClass extends SuperClass{
  void print(){
    System.out.println("Sub class implementation");
  }
}