package study.qi.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description
 * @Author qi
 * @Date 2020/11/10 17:26
 * @ClassName PaymentController
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul() {
        return "Spring Cloud with Consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}