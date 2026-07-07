package com.xaris.eventticketing.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UpdateUserEmailRequest {
    @NotBlank
    @Email
    private String email;

    public UpdateUserEmailRequest(){}

    public UpdateUserEmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
