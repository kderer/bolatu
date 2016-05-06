package com.bolatu.web.mobile.managed;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.bolatu.db.api.model.Message;

@Component
@ManagedBean(name="sessionBean")
@Scope("session")
public class SessionBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Message selectedMessage;
	private Message selectedSentMessage;
	private String userLocation;
	
	public boolean isUserLoggedIn() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null) {
			return false;
		}

		if (authentication instanceof AnonymousAuthenticationToken) {
			return false;
		}

		return authentication.isAuthenticated();
	}

	public String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null) {
			return null;
		}

		if (authentication instanceof AnonymousAuthenticationToken) {
			return null;
		}

		return authentication.getName();
	}

	public Message getSelectedMessage() {
		return selectedMessage;
	}

	public void setSelectedMessage(Message selectedMessage) {
		this.selectedMessage = selectedMessage;
	}

	public Message getSelectedSentMessage() {
		return selectedSentMessage;
	}

	public void setSelectedSentMessage(Message selectedSentMessage) {
		this.selectedSentMessage = selectedSentMessage;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	
}
