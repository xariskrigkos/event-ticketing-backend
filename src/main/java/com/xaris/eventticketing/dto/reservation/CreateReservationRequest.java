package com.xaris.eventticketing.dto.reservation;

public class CreateReservationRequest {

    private String userId;
    private String eventId;
    private int capacity;

    public CreateReservationRequest(){}

    public CreateReservationRequest(String userId, String eventId, int capacity){
        this.userId = userId;
        this.eventId = eventId;
        this.capacity = capacity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
