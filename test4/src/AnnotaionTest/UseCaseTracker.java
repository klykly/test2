package AnnotaionTest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;  
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.List;  
  
public class UseCaseTracker {  
      
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    	int i = 0;
        for(Method m : cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);  
            if(uc != null){  
            	if ( uc.id() == 47){
            		System.out.println(m.getName());
            		System.out.println(m.invoke(new PasswordUtils(), "wdw"));
            	}
                System.out.println("Found Use Case :" + uc.id() + " " + uc.description() );  
                useCases.remove(new Integer(uc.id()));  
            }  
        }  
        for(int j : useCases){  
            System.out.println("Warning : Missing use case-" + j);  
        }  
    }  
    /** 
     * @param args 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */  
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {  
        List<Integer> useCases = new ArrayList<Integer>();  
        Collections.addAll(useCases, 47, 48, 49, 50);  
        trackUseCases(useCases, PasswordUtils.class);  
    }  
  
}  