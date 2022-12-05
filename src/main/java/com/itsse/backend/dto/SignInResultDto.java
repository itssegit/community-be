package com.itsse.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SignInResultDto extends SignUpResultDto {
    //
    private String token;
    
    public SignInResultDto(boolean success, int code, String msg) {
        super(success, code, msg);
        this.token = token;
    }
}
