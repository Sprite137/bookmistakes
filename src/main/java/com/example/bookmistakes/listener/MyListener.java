package com.example.bookmistakes.listener;

import com.example.bookmistakes.event.LoginEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @EventListener(LoginEvent.class)
    public void loginListener(LoginEvent event){
        System.err.println("用户"+event.getMessage()+"登陆");
    }


}
