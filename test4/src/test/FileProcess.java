package test;

import java.io.*;

public class FileProcess {
	
	public static void main(String args[]) throws FileNotFoundException, IOException{
		
		
		File file = new File("C:/Users/hong/Desktop/전송결과.xls");
		
		String phone = "";
		String type = "";
		String status = "";
		String date = "";
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                
                if( line != null &&  line.contains("2015")){
                	date = line.substring(line.indexOf(">") + 1, line.indexOf("</td>"));
                	line = reader.readLine();
                	phone = line.substring(line.indexOf(">") + 1, line.indexOf("</td>"));                	
                	line = reader.readLine();
                	line = reader.readLine();
                	line = reader.readLine();
                	type = line.substring(line.indexOf(">") + 1, line.indexOf("</td>"));                	
                	line = reader.readLine();
                	status = line.substring(line.indexOf(">") + 1, line.indexOf("</td>"));                
                
                	System.out.println(date + " " + phone + " " + type + " " + status);
                }
            }
		}
            
	}

}
