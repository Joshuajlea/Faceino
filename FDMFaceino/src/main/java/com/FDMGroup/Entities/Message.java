package com.FDMGroup.Entities;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
}
