package com.FDMGroup.Entities;

import java.util.List;

public class User {
	
	private String loginName, password, picReference;
	private int balance;
	private List<Conversation> conversations;
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
		return conversations.add(conversation);
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
	public String getLoginName() {
		return loginName;
	}
	public String getPassword() {
		return password;
	}
	public String getPicReference() {
		return picReference;
	}
	public List<Conversation> getConversations() {
		return conversations;
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


}
