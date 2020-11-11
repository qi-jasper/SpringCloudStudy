package study.qi.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 自定义 IRule 算法
 * @Author qi
 * @Date 2020/11/11 15:05
 * @ClassName MyRule
 **/
@Configuration
public class MyRule {

    @Bean
    public IRule myRule() {
        // 自定义为 随机
        return new RandomRule();
    }
}