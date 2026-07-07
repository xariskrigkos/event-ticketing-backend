package com.xaris.eventticketing.dto.user;

import jakarta.validation.constraints.NotBlank;

public class UpdateUserNameRequest {
    @NotBlank
    private String name;

    public UpdateUserNameRequest(){}

    public UpdateUserNameRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
