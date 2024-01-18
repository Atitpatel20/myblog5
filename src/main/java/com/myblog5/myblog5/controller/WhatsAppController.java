package com.myblog5.myblog5.controller;

import com.myblog5.myblog5.payload.WhatsAppDto;
import com.myblog5.myblog5.service.WhatsAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class WhatsAppController {
    private WhatsAppService whatsAppService;

    public WhatsAppController(WhatsAppService whatsAppService) {
        this.whatsAppService = whatsAppService;
    }

    @PostMapping
    public ResponseEntity<WhatsAppDto>createRegistration(@RequestBody WhatsAppDto whatsAppDto){
        WhatsAppDto registration = whatsAppService.createRegistration(whatsAppDto);
        return new ResponseEntity<>(registration, HttpStatus.CREATED);
    }
    @GetMapping("/particular")
    public ResponseEntity<WhatsAppDto> GetDetailesById(@RequestParam long id){
        WhatsAppDto dto = whatsAppService.GetDetailesById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    // http://localhost:8080//api/users?pageNo=0&pageSize=3
    @GetMapping
    public List<WhatsAppDto> getALlUser(
            @RequestParam(name="pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "0")int pageSize
    ){
        List<WhatsAppDto> users=whatsAppService.getALlUser(pageNo,pageSize);
        return users;
    }

}
