package com.myblog5.myblog5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="whatsAppUsers")

public class WhatsApp {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private long id;
    private String name;
    private String userName;
    private String email;
    private long mobile;

}
