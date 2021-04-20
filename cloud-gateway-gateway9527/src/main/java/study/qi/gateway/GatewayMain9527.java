package study.qi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/16 17:38
 * @ClassName GatewayMain9527
 **/
@EnableEurekaClient
@SpringBootApplication
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}