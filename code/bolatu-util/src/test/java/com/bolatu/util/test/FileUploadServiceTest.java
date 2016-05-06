package com.bolatu.util.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolatu.util.fileupload.FileUploadService;

public class FileUploadServiceTest extends BaseTestConfig {
	
	@Autowired
	private FileUploadService service;
	
	@Test
	public void testFileUpload() throws IOException {
		
		BufferedImage image = ImageIO.read(new File("D:\\bolatu\\test.jpg"));
		
		boolean result = service.uploadProfilePhoto(image, "osman1");
		
		Assert.assertTrue(result);
		
		File resultImage = new File("D:\\bolatu\\photo\\osman1.png");
		
		Assert.assertTrue(resultImage.exists());		
		
	}

}
