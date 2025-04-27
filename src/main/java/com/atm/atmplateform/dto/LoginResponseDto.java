package com.atm.atmplateform.dto;

public class LoginResponseDto {

    private String tokenOrMessage;
    private boolean success;

    public LoginResponseDto(String tokenOrMessage, boolean success) {
        this.tokenOrMessage = tokenOrMessage;
        this.success = success;
    }

    public String getTokenOrMessage() {
        return tokenOrMessage;
    }

    public boolean isSuccess() {
        return success;
    }
}
