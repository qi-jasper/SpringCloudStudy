package study.qi.payment.controller;

import com.oracle.tools.packager.Log;
import org.springframework.web.bind.annotation.*;
import study.qi.entities.CommonResult;
import study.qi.entities.Payment;
import study.qi.payment.service.PaymenService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2020/8/9 22:05
 * @ClassName PaymentController
 **/

@RestController
public class PaymentController {
    @Resource
    private PaymenService paymenService;

    // 还应该有有一个 @RequestBody
    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment) {
        int result = paymenService.create(payment);
        Log.info("插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入成功！", result);
        } else {
            return new CommonResult(404, "插入失败！");
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymenService.getPaymentById(id);
        Log.info("插入结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功！", payment);
        } else {
            return new CommonResult(404, "没有对应记录！", null);
        }
    }
}