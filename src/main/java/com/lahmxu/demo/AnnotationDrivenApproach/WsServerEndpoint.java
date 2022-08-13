package com.lahmxu.demo.AnnotationDrivenApproach;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * WsServerEndpoint
 */
@Component
@ServerEndpoint("/myWs")
public class WsServerEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(WsServerEndpoint.class);

    /**
     * connect successful.
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        LOG.info("connect successful");
    }

    /**
     * connect close.
     *
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        LOG.info("connect closed");
    }

    /**
     * received message
     *
     * @param text
     */
    @OnMessage
    public String onMsg(String text) throws IOException {
        return "server send message：" + text;
    }
}