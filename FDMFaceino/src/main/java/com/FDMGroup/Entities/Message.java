package com.FDMGroup.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Id;

public class Message {
	@Id
	private String messageId;
	private String sender;
	private String content;
	private LocalDateTime time;

	protected Message() {
	}

	public Message(String sender, String content) {
		this.sender = sender;
		this.content = content;
		this.time = LocalDateTime.now();
		this.messageId = UUID.randomUUID().toString();
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public String getMessageId() {
		return messageId;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", sender=" + sender + ", content=" + content + ", time=" + time
				+ "]";
	}
	
	
	
}
