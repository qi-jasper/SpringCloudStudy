package study.qi.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.qi.entities.CommonResult;
import study.qi.entities.Payment;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/12 20:40
 * @InterfaceName PaymentFeignService
 **/
@Component
// value 的值等于要找寻的微服务的名称
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * OpenFeign 模拟测试超时使用
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();

}