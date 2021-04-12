package study.qi.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/12 20:13
 * @ClassName OpenFeignMain80
 **/
@EnableFeignClients
@SpringBootApplication
public class OpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class, args);
    }
}