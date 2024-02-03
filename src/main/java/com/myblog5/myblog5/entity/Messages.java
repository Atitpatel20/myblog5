package com.myblog5.myblog5.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    private String message;

    @ManyToOne
    @JoinColumn(name = "whatsapp_id")
    private WhatsApp whatsAppUser;
}
