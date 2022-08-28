package com.turreta.springevent.events;

import org.springframework.context.ApplicationEvent;

public class AppEventA extends ApplicationEvent  {

    public AppEventA(Object source) {
        super(source);
    }
}
