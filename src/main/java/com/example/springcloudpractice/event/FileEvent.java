package com.example.springcloudpractice.event;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class FileEvent {

    private String eventId;
    private EventType type;
    private Map<String, Object> data;

    @Builder
    public FileEvent(String eventId, EventType type, Map<String, Object> data) {
        this.eventId = eventId;
        this.type = type;
        this.data = data;
    }

    public static FileEvent toCompleteEvent(Map data) {
        return FileEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.COMPLETE)
                .data(data)
                .build();
    }

    public static FileEvent toErrorEvent(Map data) {
        return FileEvent.builder()
                .eventId(UUID.randomUUID().toString())
                .type(EventType.ERROR)
                .data(data)
                .build();
    }

}
