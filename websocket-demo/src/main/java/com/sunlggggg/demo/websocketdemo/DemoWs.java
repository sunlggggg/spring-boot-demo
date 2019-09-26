package com.sunlggggg.demo.websocketdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author sunligang
 * @date 2019/09/26
 */


@ServerEndpoint("/ws")
@Component
@Slf4j
public class DemoWs {

    @OnOpen
    public void onOpen(Session session)  {
        log.info("opened: " + session.getId());
    }

    @OnMessage
    public void onOpen(Session session, String message) throws IOException {
        log.info("opened: " + session.getId());
        log.info("message from " + session.getId() + ": " + message);
        session.getBasicRemote().sendText("response");
    }


    @OnClose
    public void onClose(Session session) {
        log.info("closed: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.info("closed: " + session.getId());
        error.printStackTrace();
    }
}
