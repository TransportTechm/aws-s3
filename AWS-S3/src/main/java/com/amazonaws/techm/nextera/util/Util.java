package com.amazonaws.techm.nextera.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Util {

	public static void writeFile(InputStream inputStream, String fileName) {
		OutputStream outputStream = null;
		try {
			String filePath = "./downloads/";
			File file = new File(filePath+fileName);
			outputStream = new FileOutputStream(file);
			
			int read = 0;
			byte[] bytes = new byte[1024];
			
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			
			System.out.println("Done!");
			
		} catch (IOException e) {
			System.out.println("Error while writing into file.");
			System.out.println("Caused by: "+e.getMessage());
		}finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
}
