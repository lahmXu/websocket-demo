package com.lahmxu.demo.InterfaceDrivenApproach;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

public class MyEndPoint extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("Peer " + session.getId() + " connected");
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                try {
                    session.getBasicRemote().sendText("Got message from " + session.getId() + " " + message);
                } catch (IOException ex) {
                }
            }
        });
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Peer " + session.getId() + " disconnected due to " + closeReason.getReasonPhrase());
    }

    @Override
    public void onError(Session session, Throwable error) {
        System.out.println("Error communicating with peer " + session.getId() + ". Detail: " + error.getMessage());
    }
}
