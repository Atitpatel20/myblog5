package com.myblog5.myblog5.service.impl;

import com.myblog5.myblog5.entity.Messages;
import com.myblog5.myblog5.entity.WhatsApp;
import com.myblog5.myblog5.payload.MessageDto;
import com.myblog5.myblog5.repository.MessageRepository;
import com.myblog5.myblog5.repository.WhatsAppRepository;
import com.myblog5.myblog5.service.MessageService;
import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private WhatsAppRepository whatsAppRepository;
    private MessageRepository messageRepository;

    public MessageServiceImpl(WhatsAppRepository whatsAppRepository, MessageRepository messageRepository) {
        this.whatsAppRepository = whatsAppRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageDto createMessage(MessageDto messageDto, long whatsappId) {
        WhatsApp whatsApp = whatsAppRepository.findById(whatsappId).orElseThrow(
                () -> new ResourceClosedException("Mesaage not found with id:" + whatsappId)
        );
        Messages messages= new Messages();
        messages.setContent(messageDto.getContent());
        messages.setMessage(messageDto.getMessage());
        messages.setWhatsAppUser(whatsApp);
        Messages savedMessages = messageRepository.save(messages);
        MessageDto dto= new MessageDto();
        dto.setId(savedMessages.getId());
        dto.setContent(savedMessages.getContent());
        dto.setMessage(savedMessages.getMessage());
        return dto;
    }
}
