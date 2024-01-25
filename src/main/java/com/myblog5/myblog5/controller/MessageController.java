package com.myblog5.myblog5.controller;

import com.myblog5.myblog5.payload.MessageDto;
import com.myblog5.myblog5.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    // http://localhost:8080/api/message?whatsappId=1
    @PostMapping
    public ResponseEntity<MessageDto> createMessage(
            @RequestBody MessageDto messageDto,
            @RequestParam long whatsappId
    ) {
        MessageDto dtos = messageService.createMessage(messageDto, whatsappId);
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
}
