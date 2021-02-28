package com.atzy.springcloud.controller;

import com.atzy.springcloud.service.impl.MessageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private MessageServiceImpl messageService;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageService.send();
    }
}
