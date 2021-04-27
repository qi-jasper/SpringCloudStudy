package study.qi.order.service;

import org.springframework.stereotype.Component;
import study.qi.entities.CommonResult;
import study.qi.entities.Payment;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/27 22:38
 * @ClassName PaymentFallbackService
 **/
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回, ---PaymentFallbackService", new Payment(id,"errorSerial"));
    }
}