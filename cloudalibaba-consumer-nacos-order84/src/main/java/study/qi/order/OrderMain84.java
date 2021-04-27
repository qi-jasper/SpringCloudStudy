package study.qi.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/27 22:34
 * @ClassName OrderMain84
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain84.class, args);
    }
}