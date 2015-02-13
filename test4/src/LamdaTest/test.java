package LamdaTest;

import java.util.*;
import java.util.function.Predicate;

import org.springframework.context.annotation.Lazy;

public class test {
	


	public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
	    int total = 0;
	    for (int number : numbers) {
	        if (p.test(number)) {
	            total += number;
	        }
	    }
	    return total;
	}

	public static void main(String args[]){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println(sumAll(numbers, n -> true));
		System.out.println(sumAll(numbers, n -> n % 2 == 0));
		System.out.println(sumAll(numbers, n -> n > 3));

		List<Map <String , Object>> mapList = new ArrayList<>();
		
	}
}
