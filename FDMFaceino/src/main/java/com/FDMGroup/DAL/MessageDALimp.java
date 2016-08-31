package com.FDMGroup.DAL;

import java.util.List;

import com.FDMGroup.DALinterfaces.MessageDAL;
import com.FDMGroup.Entities.Message;
import com.FDMGroup.Repositories.InMemoryMessageRepository;

public class MessageDALimp implements MessageDAL {

	@Override
	public Message getById(String messageId) {
		return InMemoryMessageRepository.getInstance().getById(messageId);
	}

	@Override
	public List<Message> getAll() {
		return InMemoryMessageRepository.getInstance().getAll();
	}

	@Override
	public boolean addMessage(Message msg) {
		return InMemoryMessageRepository.getInstance().add(msg);
	}

}
