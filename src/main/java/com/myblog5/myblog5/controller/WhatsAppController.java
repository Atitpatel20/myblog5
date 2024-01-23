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
    // http://localhost:8080/api/users?pageNo=0&pageSize=5&sortBy=mobile&sortDir=Desc
    @GetMapping
    public List<WhatsAppDto> getAllUser(
            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir", required = false, defaultValue = "asc") String sortDir
    ) {
        List<WhatsAppDto> users = whatsAppService.getAllUser(pageNo, pageSize, sortBy, sortDir);
        return users;
    }


}
