package com.myblog5.myblog5.service.impl;

import com.myblog5.myblog5.entity.Messages;
import com.myblog5.myblog5.entity.WhatsApp;
import com.myblog5.myblog5.exception.ResourceNotFoundException;
import com.myblog5.myblog5.payload.MessageDto;
import com.myblog5.myblog5.repository.MessageRepository;
import com.myblog5.myblog5.repository.WhatsAppRepository;
import com.myblog5.myblog5.service.MessageService;
import org.hibernate.ResourceClosedException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private WhatsAppRepository whatsAppRepository;
    private ModelMapper modelMapper;
    private MessageRepository messageRepository;

    public MessageServiceImpl(WhatsAppRepository whatsAppRepository, MessageRepository messageRepository,ModelMapper modelMapper) {
        this.whatsAppRepository = whatsAppRepository;
        this.messageRepository = messageRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public MessageDto createMessage(MessageDto messageDto, long whatsappId) {
        WhatsApp whatsApp = whatsAppRepository.findById(whatsappId).orElseThrow(
                () -> new ResourceClosedException("Mesaage not found with id:" + whatsappId)
        );
        Messages messages = mapToEntity(messageDto);
//        Messages messages= new Messages();
//        messages.setContent(messageDto.getContent());
//        messages.setMessage(messageDto.getMessage());
//        messages.setWhatsAppUser(whatsApp);
        Messages savedMessages = messageRepository.save(messages);
//        MessageDto dto= new MessageDto();
//        dto.setId(savedMessages.getId());
//        dto.setContent(savedMessages.getContent());
//        dto.setMessage(savedMessages.getMessage());
        return mapToDto(savedMessages);
    }

    @Override
    public void deleteMessageById(long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public MessageDto updateMessage(long id, MessageDto messageDto, long whatsappId) {
        WhatsApp whatsApp = whatsAppRepository.findById(whatsappId).orElseThrow(
                () -> new ResourceNotFoundException("no user found:" + whatsappId)
        );
        Messages messages = messageRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("no message found:" + id)
        );
        Messages m = mapToEntity(messageDto);
        m.setId(messages.getId());
//        messages.setContent(messageDto.getContent());
//        messages.setMessage(messageDto.getMessage());
        m.setWhatsAppUser(whatsApp);
        Messages update = messageRepository.save(m);
//        MessageDto dto= new MessageDto();
//        dto.setId(update.getId());
//        dto.setContent(update.getContent());
//        dto.setMessage(update.getMessage());
        return mapToDto(update);
    }
    MessageDto mapToDto(Messages messages){
        MessageDto dto = modelMapper.map(messages, MessageDto.class);
        return dto;
    }
    Messages mapToEntity(MessageDto messagesDto){
        Messages messages = modelMapper.map(messagesDto, Messages.class);
        return messages;
    }
}
