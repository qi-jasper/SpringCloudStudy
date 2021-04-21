package study.qi.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/21 14:21
 * @ClassName StreamProvider8801
 **/
@EnableEurekaClient
@SpringBootApplication
public class StreamProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProvider8801.class, args);
    }
}