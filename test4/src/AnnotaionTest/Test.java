package AnnotaionTest;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
 
public class Test {
 

    @Override
    @OnjInfo(name = "onj",  desc = "onjoraclejava" ,year="2200")
    public String toString() {
        return "Overriding toString method 1";
    }
 
    @Deprecated
    @OnjInfo(name = "oraclejava")
    public static void oldMethod() {
        System.out.println("old method(oraclejava),사용중지. 3");
    }
    
    @OnjInfo(name = "onjoraclejava", year="2200")
    public static void newMethod() {
        System.out.println("new method(onjoraclejava),OK. 2");
    }
 
    @SuppressWarnings({"unchecked", "deprecation" })
    @OnjInfo(name = "onj", year="2200")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("oraclejava");
        oldMethod();
    }
 
}