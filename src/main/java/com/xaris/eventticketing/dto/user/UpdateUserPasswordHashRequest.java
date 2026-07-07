package com.xaris.eventticketing.dto.user;

import jakarta.validation.constraints.NotBlank;

public class UpdateUserPasswordHashRequest {

    @NotBlank
    private String passwordHash;

    public UpdateUserPasswordHashRequest(String passwordHash){
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
