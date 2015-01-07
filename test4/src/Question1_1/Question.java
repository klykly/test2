package Question1_1;

public class Question {

	public static boolean isUniqueChars(String str) {
		if (str.length() > 128) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';

			if ((checker & (1 << val)) > 0) return false;
			checker =  checker | (1 << val);
			System.out.println(val + ":"+ str.charAt(i));
			System.out.println(Integer.toBinaryString(checker) + ":" +  str.charAt(i) +":" + i);
		}
		return true;
	}
	
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
//			System.out.println(val + " " + str.charAt(i));
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"zabcde", "hello", "apple", "kite", "padle["};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
		}
	}

}
