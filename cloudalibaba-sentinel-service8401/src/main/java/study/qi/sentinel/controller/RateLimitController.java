package study.qi.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.qi.entities.CommonResult;
import study.qi.entities.Payment;
import study.qi.sentinel.myhandler.CustomerBlockHandler;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/27 11:29
 * @ClassName RateLimitController
 **/
@RestController
public class RateLimitController {

    @SentinelResource(value = "byResource", blockHandler = "handleException")
    @GetMapping("/byResource")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试成功", new Payment(200L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + ": 服务不可用");
    }

    @SentinelResource(value = "byURL")
    @GetMapping("/limit/byURL")
    public CommonResult byURL() {
        return new CommonResult(200, "按 URL 限流测试成功", new Payment(200L, "serial002"));
    }

    /**
     * @SentinelResource 中的 blockHandlerClass 指定兜底类；blockHandler 指定兜底方法中的兜底方法
     * @return
     */
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    @GetMapping("/limit/customerBlockHandler")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客户自定义限流测试成功", new Payment(200L, "serial003"));
    }
}