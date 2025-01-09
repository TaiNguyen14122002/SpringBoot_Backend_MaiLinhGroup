package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.ResultMessage;
import com.example.MaiLinhGroup.reponsitory.ResultMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultMessageServiceImpl implements ResultMessageService{

    @Autowired
    private ResultMessageRepository resultMessageRepository;


    @Override
    public List<ResultMessage> getAllResultMessage() {
        return resultMessageRepository.findAll();
    }

    @Override
    public ResultMessage getResultMessageBySmsId(String SmsId) {
        return resultMessageRepository.findResultMessagesBySmsId(SmsId)
                .orElseThrow(() -> new RuntimeException("ResultMessage not found with ID: " + SmsId));
    }


}
