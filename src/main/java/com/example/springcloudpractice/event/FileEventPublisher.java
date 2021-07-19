package com.example.springcloudpractice.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class FileEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void notify(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }

/*    // 완료되었을 때 fileEvent 전달
    public void notifyComplete(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }
    
    // 실패했을 때 fileEvent 전달
    public void notifyError(FileEvent fileEvent) {
        applicationEventPublisher.publishEvent(fileEvent);
    }*/

}
