package com.lahmxu.demo.InterfaceDrivenApproach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.websocket.server.ServerContainer;

@Configuration
public class ServerConfig {

    @Bean
    public ServerContainer serverContainer(ServletContext context) {
        return (ServerContainer) context.getAttribute(ServerContainer.class.getName());
    }
}
