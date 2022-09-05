package com.turreta.springevent.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class AppEventAPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;  // instance to call publish method

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(AppEventA appEventA) {  // calling Event object to publish it
        this.publisher.publishEvent(appEventA);
    }
}
