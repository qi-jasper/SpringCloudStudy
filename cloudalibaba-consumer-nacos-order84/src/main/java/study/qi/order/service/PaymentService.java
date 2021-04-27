package study.qi.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.qi.entities.CommonResult;
import study.qi.entities.Payment;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/27 22:38
 * @InterfaceName PaymentService
 **/
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}