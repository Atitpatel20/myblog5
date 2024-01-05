package com.myblog5.myblog5.service.impl;

import com.myblog5.myblog5.entity.WhatsApp;
import com.myblog5.myblog5.payload.WhatsAppDto;
import com.myblog5.myblog5.repository.WhatsAppRepository;
import com.myblog5.myblog5.service.WhatsAppService;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    private WhatsAppRepository whatsAppRepository;

    public WhatsAppServiceImpl(WhatsAppRepository whatsAppRepository) {
        this.whatsAppRepository = whatsAppRepository;
    }

    @Override
    public WhatsAppDto createRegistration(WhatsAppDto whatsAppDto) {
        WhatsApp users= new WhatsApp();
        users.setUserName(whatsAppDto.getUserName());
        users.setName(whatsAppDto.getName());
        users.setEmail(whatsAppDto.getEmail());
        users.setMobile(whatsAppDto.getMobile());

        WhatsApp saveUsers = whatsAppRepository.save(users);
        WhatsAppDto dto= new WhatsAppDto();
        dto.setUserName(saveUsers.getUserName());
        dto.setName(saveUsers.getName());
        dto.setEmail(saveUsers.getEmail());
        dto.setMobile(saveUsers.getMobile());
        return dto;
    }
}
