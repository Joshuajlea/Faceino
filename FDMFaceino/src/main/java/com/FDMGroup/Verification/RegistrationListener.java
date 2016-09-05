/* made redundant 
 * 
 * package com.FDMGroup.Verification;
 

import java.util.UUID;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.codehaus.groovy.control.messages.SimpleMessage;
import org.codehaus.groovy.tools.shell.util.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.FDMGroup.DALinterfaces.UserDAL;
import com.FDMGroup.Entities.User;

import services.Userservices;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private static MessageSource messages;
    @Autowired
    private JavaMailSender mailSender;
	
 
    // JL 02/09/16
    // this should send an email to the users email address that contains the unique token ////
    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }
 
    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        com.FDMGroup.Entities.User user = event.getUser();
        String token = UUID.randomUUID().toString();
        Userservices.createVerificationToken(user, token);
         
        String recipientAddress = user.getLoginName();
        String subject = "Registration Confirmation";
        String confirmationUrl 
          = event.getAppUrl() + "/regitrationConfirm.html?token=" + token;
        String message = messages.getMessage("message.regSucc");
         
//        SimpleMessage email = new SimpleMessage(message, email, null);
//        email.
//        email.setAddress(recipientAddress);
//        email.setSubject(subject);
//        email.setText(message + " rn" + "10.10.9.82:8080" + confirmationUrl); ///need to change the url to the correct one!! ////
//        (mailSender).send(email);
        
    }
        public static final void sendSimpleMail() throws Exception {
            Email email = new SimpleEmail();
            email.setSmtpPort(25);
            email.setAuthenticator(new DefaultAuthenticator("joshua.lea@fdmgroup.com",
                    "put password here"));
            email.setDebug(false);
            email.setHostName("outlook.fdmgroup.local");
            email.setFrom("joshua.lea@fdmgroup.com");
            email.setSubject("Registration Confirmation");
            email.setMsg(messages.getMessage("message.regSucc"));
            email.addTo(User.getLoginName());
            email.setTLS(true);
            email.send();
            System.out.println("Mail sent!");
        }
        
        
    }


*/