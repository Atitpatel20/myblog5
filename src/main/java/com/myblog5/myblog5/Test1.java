package com.myblog5.myblog5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<Login> data = Arrays.asList(
                new Login("kamal","testing"),
                new Login("sarang","testing"),
                new Login("axay","testing")
        );


        List<LoginDto> dtos = data.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
        System.out.println(dtos);
    }
   static LoginDto  mapToDto (Login login){
        LoginDto dto= new LoginDto();
        dto.setUserName(login.getUserName());
        dto.setPassword(login.getPassword());
        return dto;
    }
}
