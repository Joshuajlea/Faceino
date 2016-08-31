package com.FDMGroup.Entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class Conversation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String conversationId;
	private List<String> messageIds;
	private List<String> receiverNames;
	
	public Conversation() {
	}
	
	public boolean addMessage(Message message){
		return messageIds.add(message.getMessageId());
	}
	
	public boolean addMessage(String messageId){
		return messageIds.add(messageId);
	}
	
	public boolean addReceiver(User user){
		return receiverNames.add(user.getLoginName());
	}
	
	public boolean addReceiver(String loginName){
		return receiverNames.add(loginName);
	}

	public List<String> getMessageIds() {
		return messageIds;
	}

	public void setMessageIds(List<String> messageIds) {
		this.messageIds = messageIds;
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
