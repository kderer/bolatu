package com.bolatu.db.impl.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolatu.db.api.model.Message;
import com.bolatu.db.api.model.User;
import com.bolatu.util.enumaration.MessageStatus;

@Document(collection = "message")
public class MessageImpl implements Message {
	
	@Id
	private String id;
	
	@Indexed	
	private String sender;
    
	@Indexed
	private String receiver;
	
	private String title;
	
	private String content;
	
	private Date sentDate;
	
	private Date readDate;
	
	/* R - read  U - Unread  N - New (aka Not read yet)  D - deleted */
	private char status;
	
	/*parentId can be thought like "repliedMessageId", that would keep the id of a message which is replied
	 * by the current message
	 * If there is a parent id, then the parent might be set as top level id as well*/
	private String parentId;
	
	/*This will be the id of the very first message in a conversation. In case the message is the very first one
	 * then it will simply show its own Id*/
	private String topLevelId;
	
	private char deletedFromInbox;
	
	private char deletedFromSent;
    
	public MessageImpl() {
		
	}

	public String getTopLevelId() {
		return topLevelId;
	}

	public void setTopLevelId(String topLevelId) {
		this.topLevelId = topLevelId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	public MessageImpl(User sender, User receiver, String title, String content){
		this.sender = sender.getUsername();
		this.receiver = receiver.getUsername();
		this.title = title;
		this.content = content;
		this.sentDate = new Date();
		this.status = MessageStatus.NEW.getCode();		
	}
	
	public MessageImpl(String sender, String receiver, String title, String content){
		this.sender = sender;
		this.receiver = receiver;
		this.title = title;
		this.content = content;
		this.sentDate = new Date();
		this.status = MessageStatus.NEW.getCode();		
	}

	@Override
	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public String getSender() {
		return sender;
	}

	@Override
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Override
	public String getReceiver() {
		return receiver;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	@Override
	public Date getSentDate() {
		return sentDate;
	}

	@Override
	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public char getStatus() {
		return status;
	}

	@Override
	public Date getReadDate() {
		return readDate;
	}

	@Override
	public void setReadDate(Date readDate) {
		this.readDate = readDate;		
	}

	@Override
	public char getDeletedFromInbox() {
		return deletedFromInbox;
	}

	@Override
	public void setDeletedFromInbox(char deletedFromInbox) {
		this.deletedFromInbox = deletedFromInbox;
	}

	@Override
	public char getDeletedFromSent() {
		return deletedFromSent;
	}

	@Override
	public void setDeletedFromSent(char deletedFromSent) {
		this.deletedFromSent = deletedFromSent;
	}

	public enum MessageField{
		id("id"),
		sender("sender"),
		receiver("receiver"),
		title("title"),
		content("content"),
		sentDate("sentDate"),
		readDate("readDate"),
		status("status"),
		parentId("parentId"),
		topLevelId("topLevelId"),
		deletedFromInbox("deletedFromInbox"),
		deletedFromSent("deletedFromSent"),
		collection("message");		
		
		private final String field;
		
		MessageField(String field){
			this.field = field;
		}
		
		public String getField(){
			return field;
		}
		
		public String toString(){
			return field;
		}
	}

}
