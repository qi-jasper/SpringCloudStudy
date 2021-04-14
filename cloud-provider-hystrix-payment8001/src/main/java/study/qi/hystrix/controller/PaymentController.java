package study.qi.hystrix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.qi.hystrix.service.PaymentService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/13 14:01
 * @ClassName PaymentController
 **/
@RestController
public class PaymentController {

    Logger log = LoggerFactory.getLogger("PaymentController");

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOK(id);
        log.info("*****OK Result: " + result);

        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("*****Timeout Result: " + result);

        return result;
    }
}