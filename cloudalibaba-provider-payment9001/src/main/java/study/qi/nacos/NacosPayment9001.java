package study.qi.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/23 11:06
 * @ClassName NacosPayment9001
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9001.class, args);
    }
}