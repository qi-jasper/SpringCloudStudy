package study.qi.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/21 16:03
 * @ClassName StreamConsumer8803
 **/
@EnableEurekaClient
@SpringBootApplication
public class StreamConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8803.class, args);
    }
}