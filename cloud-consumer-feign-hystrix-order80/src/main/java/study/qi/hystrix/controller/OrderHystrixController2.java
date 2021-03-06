package study.qi.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.qi.hystrix.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/13 19:53
 * @ClassName OrderHystrixController
 **/
@DefaultProperties(defaultFallback = "paymentGlobalHandler")
@RestController
public class OrderHystrixController2 {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * 立刻响应的接口
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoOK(id);
    }

    /**
     * 模拟延迟响应的接口
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
    String paymentInfoTimeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    /**
     * 上方 @HystrixCommand 注解中的处理方法，即超过 3 秒后服务出错后的处理方法
     * @param id
     * @return
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "这里是消费者80，支付系统繁忙或运行出错，请稍后再试 (T_T)~";
    }

    /**
     * 全局服务降级处理方式
     * @param id
     * @return
     */
    public String paymentGlobalHandler(Integer id) {
        return "这里是全局的服务降级处理方式，支付系统繁忙或运行出错，请稍后再试 (T_T)~";
    }
}