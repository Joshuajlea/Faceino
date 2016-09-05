package com.FDMGroup.Entities;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String messageId;
	private User sender;
	private String content;
	private LocalDateTime time;

	protected Message() {
	}

	public Message(User sender, String content) {
		this.sender = sender;
		this.content = content;
		this.time = LocalDateTime.now();
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
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
