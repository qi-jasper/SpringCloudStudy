package study.qi.nacos.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/23 13:44
 * @ClassName ApplicationContextConfig
 **/
@Configuration
public class ApplicationContextConfig {

    /**
     * 注册 RestTemplate 进 Spring 容器中
     * 使用 Ribbon 的负载均衡必须要使用 @LoadBalanced 注解！！！
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}