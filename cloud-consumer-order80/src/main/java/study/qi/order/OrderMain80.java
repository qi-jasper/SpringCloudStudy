package study.qi.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import study.qi.myrule.MyRule;

/**
 * @Description
 * @Author qi
 * @Date 2020/8/10 09:48
 * @ClassName OrderMain80
 **/
@SpringBootApplication
@EnableEurekaClient
// name：指的是要访问的支付微服务；configuration：指的是指定自定义的规则 MyRule
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}