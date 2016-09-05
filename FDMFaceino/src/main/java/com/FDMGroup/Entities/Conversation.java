package com.FDMGroup.Entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Conversation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String conversationId;
	private List<Message> messages;
	private List<User> receivers;
	
	
	
	public Conversation(List<User> receivers) {
		this.receivers = receivers;
	}

	public Conversation() {
	}
	
	public boolean addMessage(Message message){
		return messages.add(message);
	}
	
	public boolean addReceiver(User user){
		return receivers.add(user);
	}

	public List<Message> getMessages() {
		return messages;
	}

	public List<User> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<User> receivers) {
		this.receivers = receivers;
	}

	public String getConversationId() {
		return conversationId;
	}
}
