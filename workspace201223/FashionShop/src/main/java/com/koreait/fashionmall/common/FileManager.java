package com.koreait.fashionmall.common;

import java.io.File;

public class FileManager {
	private String savdDir;
	public void setSavdDir(String savdDir) {
		this.savdDir = savdDir;
	}
	public String getSavdDir() {
		return savdDir;
	}
	
	public static String getExtend(String path) {
		int lastIndex = path.lastIndexOf(".");
		String ext = path.substring(lastIndex+1, path.length());
		//System.out.println(ext);		
		return ext;
	}
	
	public static boolean deleteFile(String path) {
		File file = new File(path);
		return file.delete();
	}
}



