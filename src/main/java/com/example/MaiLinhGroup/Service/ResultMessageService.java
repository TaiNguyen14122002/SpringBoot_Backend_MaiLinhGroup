package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.ResultMessage;

import java.util.List;

public interface ResultMessageService {

    List<ResultMessage> getAllResultMessage();

    ResultMessage getResultMessageBySmsId(String SmsId);
}
