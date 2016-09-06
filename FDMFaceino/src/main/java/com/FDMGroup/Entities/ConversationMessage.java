package com.FDMGroup.Entities;

public class ConversationMessage extends Message {
	
	private String conversationId;

	public ConversationMessage(String sender, String content, String conversationId) {
		super(sender, content);
		this.conversationId = conversationId;
	}
	
	public ConversationMessage(){
		super();
	}

	public String getConversationId() {
		return conversationId;
	}

	@Override
	public String toString() {
		return "ConversationMessage [conversationId=" + conversationId + "]" + "content : " + super.getContent() + " Sender " + super.getSender() + " Time: " + super.getTime() + "MessageId: " + super.getMessageId();
	}	
	

}
