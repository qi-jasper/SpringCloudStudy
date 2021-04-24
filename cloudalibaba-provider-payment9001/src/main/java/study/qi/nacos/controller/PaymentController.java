package study.qi.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/23 11:21
 * @ClassName PaymentController
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/payment/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "Nacos Registry, serverPort: " + serverPort + ", id: " + id;
    }
}