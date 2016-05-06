package com.bolatu.web.mobile.managed.action;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bolatu.db.api.model.Message;

@Component
@ManagedBean(name="readMessageAction")
@Scope("view")
public class ReadMessageAction extends BaseAction {
			
	private Message message;	
	
	public String doInitAction() {		
		return "/message/inbox/message.xhtml";
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
