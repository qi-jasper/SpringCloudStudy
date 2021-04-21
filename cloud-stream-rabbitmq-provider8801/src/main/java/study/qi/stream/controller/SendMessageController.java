package study.qi.stream.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.qi.stream.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/21 15:00
 * @ClassName SendMessageController
 **/
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}