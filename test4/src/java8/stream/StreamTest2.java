package java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class StreamTest2 {

	
	private static void tempsss(){
//		Optional<Integer> result = numbers.stream() .reduce((x, y) -> x > y ? x : y); 
//		Integer multi = numbers.stream() .reduce(1, (x, y) -> x * y); 
//		Double reduce = numbers.parallelStream() .reduce(0.0, (val1, val2) -> Double.valueOf(val1 + val2 / 10), (val1, val2) -> val1 + val2 );
	}
	private static Log parseApacheLog(String s){
		return new Log();
		
	}
	private static void readStreamOfLinesUsingFilesWithTryBlock2() throws IOException
	{
	    Path path = Paths.get("D:/github2/test4/data", "data.txt");
	    //When filteredLines is closed, it closes underlying stream as well as underlying file.
	    try(Stream<String> filteredLines = Files.lines(path)
	                                    //test if file is closed or not
	                                    .onClose(() -> System.out.println("File closed"))
	                                    .filter(s -> s.contains("password"))){
	        Optional<String> hasPassword = filteredLines.findFirst();
	        if(hasPassword.isPresent()){
	            System.out.println(hasPassword.get());
	        }
	    }
	}
	 

	private static void temp() throws IOException{
		Path path = Paths.get("D:/github2/test4/data", "data.txt");
		try (Stream<String> lines = Files.lines(path)) {
//			OptionalDouble optionalDouble = lines.map(s -> parseApacheLog(s))
//					.filter(log -> log.getStatusCode() == 200)
//					.mapToInt(log -> log.getResponseTime()).average();
			
			
			int optionalDouble = lines.map(s -> parseApacheLog(s))
					.filter(log -> log.getStatusCode() == 200)
					.mapToInt(log -> log.getResponseTime()).sum();
			
			System.out.println(optionalDouble);
		}
	}
	private static void readStreamOfLinesUsingFilesWithTryBlock() throws IOException
	{
	    Path path = Paths.get("D:/github2/test4/data", "data.txt");
	    //When filteredLines is closed, it closes underlying stream as well as underlying file.
	    try(Stream<String> filteredLines = Files.lines(path).filter(s -> s.contains("password"))){
	        Optional<String> hasPassword = filteredLines.findFirst();
	        if(hasPassword.isPresent()){
	            System.out.println(hasPassword.get());
	        }
	    }
	}
	private static void readStreamOfLinesUsingFiles() throws IOException
	{
	    Stream<String> lines = Files.lines(Paths.get("D:/github2/test4/data", "data.txt"));
	    Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();
	    if(hasPassword.isPresent()){
	        System.out.println(hasPassword.get());
	    }
	    //Close the stream and it's underlying file as well
	    lines.close();
	}
	
	public static void main(String args[]) throws IOException{
		readStreamOfLinesUsingFiles();
		readStreamOfLinesUsingFilesWithTryBlock2();
		temp();
	}
	

}

