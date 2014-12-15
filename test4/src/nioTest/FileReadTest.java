package nioTest;

import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.io.*;

public class FileReadTest {

	public static void main(String args[]){
	    FileChannel inputChannel = null;
	    FileChannel outputChannel = null;
	    try {
	        FileInputStream is = new FileInputStream("D:/CootooRemoteCaller.java");
	        FileOutputStream out = new FileOutputStream("D:/CootooRemoteCaller.java1");
	        inputChannel = is.getChannel();
	        outputChannel = out.getChannel();        
	        
	        
	        ByteBuffer buffer = ByteBuffer.allocateDirect(512);
	        int len = -1;
	        while ( (len = inputChannel.read(buffer)) != -1) {
	            if (len == 512) {
	                buffer.position(0);
	            } else {
	                buffer.flip();
	                System.out.println("flip" + len);
	            }
	            outputChannel.write(buffer);
	            if (len == 512) {
	                buffer.rewind();
	            } else {
	                buffer.clear();
	                System.out.println("clear" + len);
	            }
	        }
	    } catch(IOException ex) {
	        //
	    } finally {
	        //
	    }
	}

    
    
}
