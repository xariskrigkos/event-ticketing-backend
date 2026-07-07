package com.xaris.eventticketing.dto.event;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class UpdateEventStartsAtRequest {
    @NotNull
    private LocalDateTime startsAt;

    public UpdateEventStartsAtRequest(LocalDateTime startsAt){
        this.startsAt = startsAt;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(LocalDateTime startsAt) {
        this.startsAt = startsAt;
    }
}
