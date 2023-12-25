package com.ProcessMining.dbutility;

import java.io.File;
import java.io.FileOutputStream;

public class Test {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream(new File("f://ram.txt"));
		
		String str = "PANKAJ";
		byte[] b = str.getBytes();
		fos.write(b);
		fos.close();
	}

}
