package com.socket;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendFile {
	  public final int SOCKET_PORT = 8800;
	  public final String SERVER = "127.0.0.1";
	  
	  public final int FILE_SIZE = 10000000; 
	  
	  public void kirimFile(String path) throws IOException {
		
	    Socket sock = null;
	    String FILE_TO_SEND = path;
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    OutputStream os = null;
	    
	    try {
			sock = new Socket(SERVER, SOCKET_PORT);
			System.out.println("Connecting...");
			      
			//sending file
			File myFile = new File (FILE_TO_SEND);
			byte [] mybytearray  = new byte [(int)myFile.length()];
			fis = new FileInputStream(myFile);
			bis = new BufferedInputStream(fis);
			bis.read(mybytearray,0,mybytearray.length);
			os = sock.getOutputStream();
			DataOutputStream out = new DataOutputStream(os);
			out.writeUTF(myFile.getName());
			System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
			os.write(mybytearray,0,mybytearray.length);
			os.flush();
			
	    }
	    finally {
	      if (fis != null) fis.close();
	      if (bis != null) bis.close();
	      if (sock != null) sock.close();
	    }
	  }
}
