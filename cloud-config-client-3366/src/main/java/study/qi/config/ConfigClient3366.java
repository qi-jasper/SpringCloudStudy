package study.qi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/20 16:41
 * @ClassName ConfigClient3366
 **/
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366.class, args);
    }
}