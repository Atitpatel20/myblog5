package com.myblog5.myblog5.service;

import com.myblog5.myblog5.entity.Messages;
import com.myblog5.myblog5.payload.MessageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageService  {
    MessageDto createMessage(MessageDto messageDto,long whatsappId);
}
