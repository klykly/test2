package AnnotaionTest;

import static org.junit.Assert.*;
import org.junit.Test;

public class Testable {  
    public void execute(){  
        System.out.println("Executing.....");  
    }  
    @Test void testExecute(){ execute(); }  
}  