package java7.folkJoin;

import java.io.File;
import java.io.IOException;

public class Snippet {
	public static void main(String[] args) throws IOException {
	    WordCounter wordCounter = new WordCounter();
	    Folder folder = Folder.fromDirectory(new File(args[0]));
	    System.out.println(wordCounter.countOccurrencesOnSingleThread(folder, args[1]));
	}
}

