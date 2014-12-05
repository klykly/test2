package AnnotaionTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
 
public class AnnoParse {
 
    public static void main(String[] args) {
    	
//    	Test test = new Test();
//    	System.out.println(test.toString());
//    	
//    	Class clazz = test.getClass();
//    	
//    	for( Field field : clazz.getDeclaredFields()){
//    		System.out.println(1);
//    		if( field.getAnnotation(OnjInfo.class ) != null){
//    			System.out.println(2);
//                OnjInfo methodAnno = field
//                        .getAnnotation(OnjInfo.class);
//                try {
//                    // iterates all the annotations available in the method
//                    for (Annotation anno : field.getDeclaredAnnotations()) {
//                        System.out.println("Annotation in Method '"
//                                + field + "' : " + anno);
//                    }
//                    if (methodAnno.year() == "2200") {
//                        System.out.println("forever!! oraclejava, onj"+field);
//                    }
//
//                } catch (Throwable ex) {
//                    ex.printStackTrace();
//                }
//    		}
//    	}
    	
    	for(Annotation ann:  AnnoParse.class.getAnnotations()){
    			System.out.println(ann.annotationType().getCanonicalName());
    	}    	
    	
        try {
            for (Method method : AnnoParse.class
                    .getClassLoader()
                    .loadClass(("AnnotaionTest.Test"))
                    .getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method
                        .isAnnotationPresent(OnjInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
//                            System.out.println("Annotation in Method '"+ method + "' : @@@" + anno);
                        }
                        
                        OnjInfo methodAnno = method
                                .getAnnotation(OnjInfo.class);
                        if (methodAnno.year().equals("2200")) {
//                            System.out.println("forever!! oraclejava, onj"+ method);
                        }else{
//                        	System.out.println("WHAT:" +method + methodAnno);
                        }
                        
                        System.out.println(method.invoke(null));
                        
 
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }else
                {
//                	System.out.println(method.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}