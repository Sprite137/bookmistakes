package com.example.bookmistakes.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class LoginEvent extends ApplicationEvent{
    private String message;
    public LoginEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
