package com.bolatu.web.mobile.managed.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.imageio.ImageIO;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.db.api.model.User;
import com.bolatu.rest.client.service.request.user.UpdateProfileRequestImpl;
import com.bolatu.rest.client.service.request.user.UserProfileRequestImpl;
import com.bolatu.service.api.request.user.UpdateProfileRequest;
import com.bolatu.service.api.response.user.UpdateProfileResponse;
import com.bolatu.service.api.response.user.UserProfileResponse;
import com.bolatu.service.api.service.UserService;
import com.bolatu.util.I18NUtil;
import com.bolatu.util.LogUtil;
import com.bolatu.util.fileupload.FileUploadService;

@Component
@ManagedBean(name="profileAction")
@Scope("view")
public class ProfileAction extends BaseAction {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	private User loggedInUser; 
	private UploadedFile uploadedPhoto;
	
	@PostConstruct
	public void init() {
		UserProfileResponse response = userService.getUserProfile(
				new UserProfileRequestImpl(sessionBean.getLoggedInUsername()));
		
		loggedInUser = response.getUser();
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}
	
	public void updateProfile() {
		if (uploadedPhoto != null && uploadedPhoto.getSize() > 0) {
			boolean uploadSuccessful = true;
			try {
				BufferedImage uploadedImage = ImageIO.read(uploadedPhoto.getInputstream());
				uploadSuccessful = fileUploadService.uploadProfilePhoto(uploadedImage,
						sessionBean.getLoggedInUsername());
			} catch (IOException e) {
				LogUtil.printExceptionLog(LogUtil.WEBMOBILELOGGER, e);
			}
			
			if (!uploadSuccessful) {
				addErrorMessage(I18NUtil.getMessage("client.message.user.profile.photo.upload.error"));
				return;
			}
		}
		
		UpdateProfileRequest request = new UpdateProfileRequestImpl();
		request.setUser(loggedInUser);
		
		UpdateProfileResponse response = userService.updateProfile(request);
		
		prepareResult(response, true, null);		
	}
	
	public String getProfilePhotoUrl() {
		return fileUploadService.getProfilePhotoFolderUrl(sessionBean.getLoggedInUsername());
	}

	public UploadedFile getUploadedPhoto() {
		return uploadedPhoto;
	}

	public void setUploadedPhoto(UploadedFile uploadedPhoto) {
		this.uploadedPhoto = uploadedPhoto;
	}
	
}
