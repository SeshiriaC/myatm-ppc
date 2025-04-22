package com.atm.atmplateform.dto;

public class LoginResponseDto {

    private String message;
    private boolean success;

    public LoginResponseDto(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
