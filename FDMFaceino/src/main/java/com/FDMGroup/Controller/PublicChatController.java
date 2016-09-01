package com.FDMGroup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FDMGroup.Entities.Message;

@Controller
public class PublicChatController {

	@Autowired
	private SimpMessagingTemplate messageConverter;

    @MessageMapping("/public")
    public Message sendMessage(Message message) throws Exception {
    	System.out.println(message.getContent());
    	messageConverter.convertAndSend("/user/queue/messages", message);
        return message;
    }
    
    @RequestMapping("/sendall")
    public String publicChat(){
    	return "chat";

    }
}
