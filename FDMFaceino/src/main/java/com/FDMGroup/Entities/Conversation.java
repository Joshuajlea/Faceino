package com.FDMGroup.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conversation {
	private String conversationId;
	private List<Message> messages = new ArrayList<Message>();
	private List<User> receivers = new ArrayList<User>();	
	
	
	public Conversation(List<User> receivers) {
		this.receivers = receivers;
		this.conversationId = UUID.randomUUID().toString();
	}

	public Conversation() {
		this.conversationId = UUID.randomUUID().toString();
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

	@Override
	public String toString() {
		return "Conversation [conversationId=" + conversationId + ", messages=" + messages + ", receivers=" + receivers
				+ "]";
	}
}
