package study.qi.hystrix.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/13 12:29
 * @ClassName PaymentService
 **/
@Service
public class PaymentService {

    /**
     * 能够正常访问的方法
     * @param id
     * @return
     */
    public String paymentInfoOK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK, id: " + id + "\t" + "O(∩_∩)O";
    }

    /**
     * 模拟超时的方法 @HystrixCommand 注解中 fallbackMethod 方法需要自己定义
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            // 设置 3 秒之内走正常业务逻辑
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeout(Integer id) {
        // 模拟需要请求 5 秒
        int time = 5;
        // 模拟错误情况
        // int a = 10 / 0;
        // 模拟超时
        try {
            TimeUnit.SECONDS.sleep(time);
            // TimeUnit.MICROSECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_Timeout, id: " + id + "\t" + "耗时 " + time + " 秒钟 (T_T)";
    }

    /**
     * 上方 @HystrixCommand 注解中的处理方法，即超过 3 秒后服务出错后的处理方法
     * @param id
     * @return
     */
    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "系统繁忙或运行出错，请稍后再试 (T_T)~";
    }

    /**
     * 新增服务熔断
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), // 失败率达到多少后熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }

        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}