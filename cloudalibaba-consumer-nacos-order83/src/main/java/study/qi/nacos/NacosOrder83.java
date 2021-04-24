package study.qi.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/23 13:41
 * @ClassName NacosOrder83
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class NacosOrder83 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrder83.class, args);
    }
}