package com.example.MaiLinhGroup.controller;

import com.example.MaiLinhGroup.Service.ResultMessageService;
import com.example.MaiLinhGroup.modal.Message;
import com.example.MaiLinhGroup.modal.ResultMessage;
import com.example.MaiLinhGroup.reponsitory.ResultMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resultMessage")
public class ResultMessageController {

    @Autowired
    private ResultMessageRepository resultMessageRepository;

    @Autowired
    private ResultMessageService resultMessageService;

    @GetMapping()
    public Page<ResultMessage> getAllResultMessage(@RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        return resultMessageRepository.findAll(pageable);
    }

    @GetMapping("/{smsId}")
    public ResultMessage getResultMessageBySmsId(@PathVariable String smsId) {
        return resultMessageService.getResultMessageBySmsId(smsId);
    }
}
