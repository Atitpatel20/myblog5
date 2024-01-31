package com.myblog5.myblog5.service;

import com.myblog5.myblog5.payload.MessageDto;

public interface MessageService  {
    MessageDto createMessage(MessageDto messageDto,long whatsappId);

    void deleteMessageById(long id);

    MessageDto updateMessage(long id, MessageDto messageDto, long whatsappId);
}
