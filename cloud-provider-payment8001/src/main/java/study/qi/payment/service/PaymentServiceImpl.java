package study.qi.payment.service;

import org.springframework.stereotype.Service;
import study.qi.entities.Payment;
import study.qi.payment.dao.PaymentDao;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2020/8/9 21:59
 * @ClassName PaymentServiceImpl
 **/
@Service
public class PaymentServiceImpl implements PaymenService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
