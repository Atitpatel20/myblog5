package com.myblog5.myblog5.repository;

import com.myblog5.myblog5.entity.WhatsApp;
import com.myblog5.myblog5.payload.WhatsAppDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhatsAppRepository extends JpaRepository<WhatsApp,Long> {
}
