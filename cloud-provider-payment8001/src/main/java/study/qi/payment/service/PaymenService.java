package study.qi.payment.service;

import org.apache.ibatis.annotations.Param;
import study.qi.entities.Payment;

/**
 * @Description
 * @Author qi
 * @Date 2020/8/9 21:57
 * @ClassName PaymenService
 **/
public interface PaymenService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
