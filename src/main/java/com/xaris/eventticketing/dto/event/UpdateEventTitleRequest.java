package com.xaris.eventticketing.dto.event;

import jakarta.validation.constraints.NotBlank;

public class UpdateEventTitleRequest {
    @NotBlank
    private String title;

    public UpdateEventTitleRequest(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
