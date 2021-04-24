package study.qi.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/23 11:52
 * @ClassName NacosPayment9002
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9002.class, args);
    }
}