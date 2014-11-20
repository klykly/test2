package java8.Lamda;

import java.util.Arrays;
import java.util.List;

public class Snippet {
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
		sumAll(numbers, n -> true);
		sumAll(numbers, n -> n % 2 == 0);
	}
	
}

