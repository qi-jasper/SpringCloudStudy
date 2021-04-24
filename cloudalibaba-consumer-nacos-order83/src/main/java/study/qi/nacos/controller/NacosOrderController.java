package study.qi.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/23 13:45
 * @ClassName NacosOrderController
 **/
@RestController
public class NacosOrderController {

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/nacos/payment/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        // 调用 cloudalibaba-provider-payment 微服务（有 9001 和 9002）的 controller 层中的接口
        return restTemplate.getForObject(serverURL + "/nacos/payment/" + id, String.class);
    }
}