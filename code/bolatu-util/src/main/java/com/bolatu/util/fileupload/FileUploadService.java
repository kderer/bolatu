package com.bolatu.util.fileupload;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bolatu.util.LogUtil;

@Service
public class FileUploadService {

	private static final int IMG_WIDTH = 96;
	private static final int IMG_HEIGHT = 96;

	@Value("${file.profile.photo.upload.path}")
	private String profilePhotoUploadPath;

	@Value("${file.profile.photo.folder.url}")
	private String profilePhotoFolderUrl;

	public boolean uploadProfilePhoto(BufferedImage image, String username) {
		BufferedImage resizedImage = resizePhoto(image);
		
		if (resizedImage != null) {
			try {
				ImageIO.write(resizedImage, "png", new File(profilePhotoUploadPath + File.separator +
						username + ".png"));
				return true;
			}
			catch(Exception e) {
				LogUtil.printExceptionLog(LogUtil.UTILLOGGER, e);
			}
		}
		
		return false;
	}

	private BufferedImage resizePhoto(BufferedImage originalImage) {
		try {
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
			g.dispose();
			g.setComposite(AlphaComposite.Src);

			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			return resizedImage;
		} catch (Exception ex) {
			LogUtil.printExceptionLog(LogUtil.UTILLOGGER, ex);
		}
		
		return null;
	}
	
	public String getProfilePhotoFolderUrl() {
		return profilePhotoFolderUrl;
	}
	
	public String getProfilePhotoFolderUrl(String username) {
		return profilePhotoFolderUrl + username + ".png";
	}

}
