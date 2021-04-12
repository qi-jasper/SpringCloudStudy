package study.qi.openfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/12 21:32
 * @ClassName FeignConfig
 **/
@Configuration
public class FeignConfig {

    /**
     * FeignClien 配置日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        // 配置详细日志级别，显示请求和响应的头信息，请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}