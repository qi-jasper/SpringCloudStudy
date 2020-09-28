package study.qi.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.qi.entities.CommonResult;
import study.qi.entities.Payment;


import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2020/8/10 11:25
 * @ClassName OrderController
 **/

@RestController
public class OrderController {
    /**
     * 这里没有 OrderService 了，而是两个服务之间的调用，Order 调用 Payment
     * 使用 restTemplate
     */
    public static final String URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "payment/get/" + id, CommonResult.class);
    }
}
