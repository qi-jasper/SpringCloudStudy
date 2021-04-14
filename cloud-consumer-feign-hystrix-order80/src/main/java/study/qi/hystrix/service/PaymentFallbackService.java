package study.qi.hystrix.service;

import org.springframework.stereotype.Component;

/**
 * @Description 实现 PaymentHystrixService 接口，用于统一处理该接口中所有方法的降级服务
 * @Author qi
 * @Date 2021/4/14 13:48
 * @ClassName PaymentFallbackService
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "PaymentFallbackService.paymentInfoOK() Fall Back (T_T)~";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentFallbackService.paymentInfoTimeout() Fall Back (T_T)~";
    }
}