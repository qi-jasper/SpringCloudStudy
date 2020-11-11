package study.qi.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Description
 * @Author qi
 * @Date 2020/8/10 09:48
 * @ClassName OrderMain80
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}