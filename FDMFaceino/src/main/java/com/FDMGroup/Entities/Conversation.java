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
	private List<String> receiverNames;
	
	public Conversation() {
	}
	
	public boolean addMessage(Message message){
		return messages.add(message);
	}
	
	public boolean addReceiver(User user){
		return receiverNames.add(user.getLoginName());
	}
	
	public boolean addReceiver(String loginName){
		return receiverNames.add(loginName);
	}

	public List<Message> getMessages() {
		return messages;
	}

	public List<String> getReceiverNames() {
		return receiverNames;
	}

	public void setReceiverNames(List<String> receiverNames) {
		this.receiverNames = receiverNames;
	}

	public String getConversationId() {
		return conversationId;
	}
}
