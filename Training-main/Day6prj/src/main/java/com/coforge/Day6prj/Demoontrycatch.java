package com.coforge.Day6prj;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demoontrycatch {
	public static void main(String[] args) throws IOException {
		int a = 5;
		int b = 0;
//
//			try {
//				System.out.println(a/b);
//				
//			} catch (Exception e) {
//			System.out.println("Exception occuredd");
//				e.printStackTrace();
//				System.out.println(e.getMessage());
//				
//			}
//					System.out.println("heeloo");
//		String string = null;
//		
//		try {
//			System.out.println(string.charAt(3));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			System.out.println("application completed");
//		}
		
//		File file = new File("data.text");
//		file.delete();
//		if(file!=null)
//		{
//			System.out.println(" found");
//		}
//		else 
//		System.out.println("not found");
//			throw new FileNotFoundException();
		FileReader reader=null;
		try {
			reader = new FileReader("data.txtr");
			int ch;
			while((ch=reader.read())!=1)
				System.out.println((char)ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(reader!=null)
			reader.close();
			}
			catch (IOException e) {
				System.out.println("exception occurred");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
