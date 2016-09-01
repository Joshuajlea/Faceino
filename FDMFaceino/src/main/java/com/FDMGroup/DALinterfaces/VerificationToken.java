package com.FDMGroup.DALinterfaces;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.FDMGroup.Entities.User;

@Entity

public class VerificationToken {
	private static final int EXPIRATION = 60 * 24;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String token;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;


	private boolean verified;
	
	public VerificationToken() {
		super();
		
	}
	
	public VerificationToken(String token, User user) {
		super();
		this.token = token;
		this.user = user;
		this.expiryDate = calculatedExpiryDate(EXPIRATION);
		this.verified = false;
	}
	

	private Object calculatedExpiryDate(int expiryTimeMinutes) {
		Calender cal = Calender.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime)));
		cal.add(Calender.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

	
	}
	
}
