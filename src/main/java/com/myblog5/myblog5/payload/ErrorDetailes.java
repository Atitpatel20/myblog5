package com.myblog5.myblog5.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetailes {
    private String message;
    private Date date;
    private String uri;
}
