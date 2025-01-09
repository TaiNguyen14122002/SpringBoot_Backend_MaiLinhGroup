package com.example.MaiLinhGroup.controller;

import com.example.MaiLinhGroup.Service.MessageService;
import com.example.MaiLinhGroup.modal.Branch;
import com.example.MaiLinhGroup.modal.Message;
import com.example.MaiLinhGroup.reponsitory.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping()
    public Page<Message> getAllMessages(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return messageRepository.findAll(pageable);

    }

    @GetMapping("/{smsId}")
    public Message getMessageBySmsId(@PathVariable String smsId) {
        return messageService.getMessageBySmsId(smsId);
    }

}
