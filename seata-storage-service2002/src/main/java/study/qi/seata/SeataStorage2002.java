package study.qi.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/28 11:30
 * @ClassName SeataStorage2002
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SeataStorage2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorage2002.class, args);
    }
}