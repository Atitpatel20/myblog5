package com.myblog5.myblog5.service;

import com.myblog5.myblog5.payload.WhatsAppDto;

import java.util.List;

public interface WhatsAppService {
    WhatsAppDto createRegistration(WhatsAppDto whatsAppDto);

    WhatsAppDto GetDetailesById(long id);

    List<WhatsAppDto> getALlUser(int pageNo, int pagesize);
}
