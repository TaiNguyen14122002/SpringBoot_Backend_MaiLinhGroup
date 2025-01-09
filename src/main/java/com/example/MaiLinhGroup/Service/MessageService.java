package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.Message;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();

    Message getMessageBySmsId(String smsId);
}
