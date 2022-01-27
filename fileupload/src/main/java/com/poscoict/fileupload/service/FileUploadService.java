package com.poscoict.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	private static String SAVE_PATH = "/Users/wonseok/upload-images";
	
	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		try {
		if(multipartFile.isEmpty()) {
			return url;
		}
		
		//사용자가 올린 파일 = getOriginalFilename
		String originFileName = multipartFile.getOriginalFilename();
		long fileSize = multipartFile.getSize();
		
		System.out.println("#########################"+originFileName);
		System.out.println("#########################"+fileSize);
		
		byte[] data = multipartFile.getBytes();
		//dir 존재하지않으면 프로그램이 만들어주게끔
		OutputStream os = new FileOutputStream(SAVE_PATH + "");
		} catch(IOException ex) {
			throw new RuntimeException("file upload error:"+ex);
		}
		return url;
	}

}
