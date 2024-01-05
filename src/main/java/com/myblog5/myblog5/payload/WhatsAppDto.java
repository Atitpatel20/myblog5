package com.myblog5.myblog5.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhatsAppDto {

    private long id;
    private String name;
    private String userName;
    private String email;
    private long mobile;
}
