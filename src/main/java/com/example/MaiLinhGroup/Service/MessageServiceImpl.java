package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.Message;
import com.example.MaiLinhGroup.reponsitory.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageBySmsId(String smsId) {
        return messageRepository.findBySmsId(smsId)
                .orElseThrow(() -> new RuntimeException("Message not found with ID: " + smsId));
    }


}
