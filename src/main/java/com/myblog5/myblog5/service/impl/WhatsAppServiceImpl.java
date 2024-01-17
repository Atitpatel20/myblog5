package com.myblog5.myblog5.service.impl;

import com.myblog5.myblog5.entity.WhatsApp;
import com.myblog5.myblog5.exception.ResourceNotFoundException;
import com.myblog5.myblog5.payload.WhatsAppDto;
import com.myblog5.myblog5.repository.WhatsAppRepository;
import com.myblog5.myblog5.service.WhatsAppService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    private WhatsAppRepository whatsAppRepository;

    public WhatsAppServiceImpl(WhatsAppRepository whatsAppRepository) {
        this.whatsAppRepository = whatsAppRepository;
    }

    @Override
    public WhatsAppDto createRegistration(WhatsAppDto whatsAppDto) {
        WhatsApp users = mapToEntity(whatsAppDto);

        WhatsApp saveUsers = whatsAppRepository.save(users);
        WhatsAppDto dto = mapToDto(saveUsers);
        return dto;
    }

    @Override
    public WhatsAppDto GetDetailesById(long id) {
        WhatsApp whatsApp = whatsAppRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Record not found with id:" + id)
        );
        WhatsAppDto dto = mapToDto(whatsApp);
        return dto;
    }

    @Override
    public List<WhatsAppDto> getALlUser() {
        List<WhatsApp> users = whatsAppRepository.findAll();
        List<WhatsAppDto> dtos = users.stream().map(w -> mapToDto(w)).collect(Collectors.toList());
        return dtos;
    }
    WhatsAppDto mapToDto (WhatsApp whatsApp){
        WhatsAppDto dto= new WhatsAppDto();
        dto.setId(whatsApp.getId());
        dto.setName(whatsApp.getName());
        dto.setUserName(whatsApp.getUserName());
        dto.setEmail(whatsApp.getEmail());
        dto.setMobile(whatsApp.getMobile());
        return dto;
    }
   WhatsApp mapToEntity(WhatsAppDto whatsAppDto){
       WhatsApp whatsApp= new WhatsApp();
       whatsApp.setId(whatsAppDto.getId());
       whatsApp.setUserName(whatsAppDto.getUserName());
       whatsApp.setName(whatsAppDto.getUserName());
       whatsApp.setEmail(whatsAppDto.getEmail());
       whatsApp.setMobile(whatsAppDto.getMobile());
        return whatsApp;
    }
}
