package com.FDMGroup.Entities;

public class ConversationMessage extends Message {
	
	private String conversationId;

	public ConversationMessage(User sender, String content, String conversationId) {
		super(sender, content);
		this.conversationId = conversationId;
	}

	public String getConversationId() {
		return conversationId;
	}

}
