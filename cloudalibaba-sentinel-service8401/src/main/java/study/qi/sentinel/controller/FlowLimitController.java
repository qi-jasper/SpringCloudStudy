package study.qi.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/25 21:44
 * @ClassName FlowLimitController
 **/
@RestController
public class FlowLimitController {

    Logger log = LoggerFactory.getLogger("FlowLimitController");

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");

        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("testD 异常比例");
        int age = 10 / 0;

        return "-------testD";
    }

    /**
     * 模拟 HotKey，使用自定义的兜底方法
     * @param p1
     * @param p2
     * @return
     */
    @SentinelResource(value = "hotKeyTest", blockHandler = "dealHotKeyTest", fallback = "fallback")
    @GetMapping("/hotKeyTest")
    public String hotKeyTest(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "Hot Key Test";
    }

    /**
     * 兜底的方法，和上面的参数一样，不错需要加入 BlockException
     * @param p1
     * @param p2
     * @param exception 必须要加上 BlockException，即出现异常后的处理方式
     * @return
     */
    public String dealHotKeyTest (String p1, String p2, BlockException exception)
    {
        // Sentinel 的默认提示都是：Blocked by Sentinel（flow limiting），这里修改为自定义提示
        return "------dealHotKeyTest,o(╥﹏╥)o";
    }
}