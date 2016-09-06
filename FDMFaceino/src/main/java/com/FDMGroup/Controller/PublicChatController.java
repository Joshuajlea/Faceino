package com.FDMGroup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.FDMGroup.Entities.Message;

@Controller
public class PublicChatController {

	@Autowired
	private SimpMessagingTemplate messageConverter;

    @MessageMapping("/public")
    public Message sendMessage(Message message) throws Exception {
    	messageConverter.convertAndSend("/user/topic/messages", message);
        return message;
    }
    
}
