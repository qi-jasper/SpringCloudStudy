package study.qi.openfeign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.qi.entities.CommonResult;
import study.qi.entities.Payment;
import study.qi.openfeign.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/12 20:47
 * @ClassName OrderFeignController
 **/
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * OpenFeign 模拟测试超时使用
     * @return
     */
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // OpenFeign-Ribbon，客户端一般默认等待 1 秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

}