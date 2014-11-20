package java7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class test {

	public static void main(String[] args) {
		int i = 1000;
		int j = 1_000;
		Map<String, List<String>> trades = new TreeMap<> ();
	
	
	
		try( FileInputStream fis = new FileInputStream(args[0]) ){
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
	
	
	

}
