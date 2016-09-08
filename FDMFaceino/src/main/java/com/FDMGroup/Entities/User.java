package com.FDMGroup.Entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String loginName, password, picReference;
	private int balance;
	private List<Conversation> conversations = new ArrayList<Conversation>();
	private List<Message> content = new ArrayList<Message>();
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
	
	public String getName(){
		return loginName.split("@")[0];
	}
	
	public boolean addConversation(Conversation conversation){
		return conversations.add(conversation);
	}
	
	public boolean addContent(Message message){
		return content.add(message);
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
	public List<Message> getContent() {
		return content;
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

	/*// verification boolean
	@Column(name = "enabled")
    private boolean enabled;
     
    public User() {						////// Made redundant
        super();
        this.enabled=false;
    }
    ///////////////////////////// */
	public String getEmail() {
		return null;
	}
}
