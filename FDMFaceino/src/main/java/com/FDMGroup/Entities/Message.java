package com.FDMGroup.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Id;

public class Message implements Comparable<Message> {
	@Id
	private final String messageId;
	private String sender;
	private String content;
	private final LocalDateTime time;
	public String displayTime ;

	protected Message() {
		this.time = LocalDateTime.now();
		this.messageId = UUID.randomUUID().toString();
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

	public String toString() {

		return this.getSender() + "\t " + this.getContent() + " \t" + this.getTime().getHour() + " "
				+ this.getTime().getMinute() + " " + this.getTime().getSecond();
	}

	@Override
	public int compareTo(Message o) {
		if (this.getTime().isBefore(o.getTime())) {
			return -1;
		}
		return 1;
	}

}
