package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.LogMessage;
import com.example.MaiLinhGroup.reponsitory.LogMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogMessageServiceImpl implements LogMessageService{

    @Autowired
    private LogMessageRepository logMessageRepository;

    @Override
    public List<LogMessage> getAllLogMessages() {
        return logMessageRepository.findAll();
    }
}
