package com.FDMGroup.Entities;

import java.util.List;

import javax.persistence.Column;

public class User {
	
	private static String loginName;
	private String password;
	private String picReference;
	private int balance;
	private List<String> conversationIds;
	private List<String> messageIds;
	private boolean active,
					blocked;
	private List<String> roles;
	
	public User(String loginName, String password, String picReference, List<String> roles) {
		this.loginName = loginName;
		this.password = password;
		this.picReference = picReference;
		this.balance = 1000;
		this.roles = roles;
		
		
	}
	
	public boolean addConversation(Conversation conversation){
		return conversationIds.add(conversation.getConversationId());
	}
	
	public boolean addConversation(String conversationId){
		return conversationIds.add(conversationId);
	}
	
	public boolean addContent(String messageId){
		return messageIds.add(messageId);
	}
	
	public boolean addContent(Message message){
		return messageIds.add(message.getMessageId());
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public static String getLoginName() {
		return loginName;
	}
	public String getPassword() {
		return password;
	}
	public String getPicReference() {
		return picReference;
	}
	public List<String> getConversationIds() {
		return conversationIds;
	}
	public List<String> getMessageIds() {
		return messageIds;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	public List<String> getRoles() {
		return roles;
	}

	// verification boolean
	@Column(name = "enabled")
    private boolean enabled;
     
    public User() {
        super();
        this.enabled=false;
    }
    /////////////////////////////
	public String getEmail() {
		return null;
	}
}
