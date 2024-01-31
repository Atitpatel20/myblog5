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
    // http://localhost:8080/api/message/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String >deleteMessageById(@PathVariable long id){
        messageService.deleteMessageById(id);
        return new ResponseEntity<>("message is deleted",HttpStatus.OK);
    }
    // http://localhost:8080/api/message/2/whatsapp/4
    @PutMapping("/{id}/whatsapp/{whatsappId}")
    public ResponseEntity<MessageDto> updateMessage(@PathVariable long id,@RequestBody MessageDto messageDto,@PathVariable long whatsappId){
        MessageDto dto= messageService.updateMessage(id,messageDto,whatsappId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
