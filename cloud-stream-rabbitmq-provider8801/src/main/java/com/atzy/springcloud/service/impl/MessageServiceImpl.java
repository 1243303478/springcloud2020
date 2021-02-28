package com.atzy.springcloud.service.impl;

import com.atzy.springcloud.service.IMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)
public class MessageServiceImpl implements IMessageService {
    public MessageChannel messageChannel;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial:"+serial);
        return serial;
    }
}
