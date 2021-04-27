package study.qi.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import study.qi.entities.CommonResult;
import study.qi.entities.Payment;
import study.qi.order.service.PaymentService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/27 22:40
 * @ClassName CircleBreakerController
 **/
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    // @SentinelResource(value = "fallback")  // 没有配置
    // @SentinelResource(value = "fallback", fallback = "handlerFallback")    // fallback 只负责业务异常
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler")   // blockHandler 只负责 Sentinel 控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    @RequestMapping("/consumer/fallback/{id}")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException, 非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException, 该 ID 没有对应记录,空指针异常");
        }

        return result;
    }

    /**
     * 本例是 fallback，处理 Java 代码运行时异常的兜底方法
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444,"兜底异常 HandlerFallbackException 内容 " + e.getMessage(), payment);
    }

    /**
     * 本例是 blockHandler，处理 Sentinel 配置违规异常后的兜底方法
     * @param id
     * @param blockException
     * @return
     */
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445,"BlockHandler-Sentinel限流, 无此流水: BlockException " + blockException.getMessage(), payment);
    }

    /**
     * OpenFeign
     */
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}