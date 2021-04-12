package study.qi.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author qi
 * @Date 2020/8/10 12:31
 * @ClassName ApplicationContextConfig
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    赋予RestTemplate负载均衡的能力
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
