package study.qi.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/28 13:51
 * @ClassName MyBatisConfig
 **/
@Configuration
@MapperScan({"study.qi.seata.dao"})
public class MyBatisConfig {

}