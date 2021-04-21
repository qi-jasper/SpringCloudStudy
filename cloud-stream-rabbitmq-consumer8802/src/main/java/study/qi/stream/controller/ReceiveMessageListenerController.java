package study.qi.stream.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/21 16:05
 * @ClassName ReceiveMessageListenerController
 **/
@EnableBinding(Sink.class)
@Component
public class ReceiveMessageListenerController {

    @Value("${server.port")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("Consumer 8803 receive message: " + message.getPayload() + " , serverPort is: " + serverPort);
    }
}