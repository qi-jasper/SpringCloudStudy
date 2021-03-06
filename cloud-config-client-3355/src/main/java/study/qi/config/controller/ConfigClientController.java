package study.qi.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/20 14:16
 * @ClassName ConfigClientController
 **/
@RestController
public class ConfigClientController {

    /**
     * 读取的是 GitHub 上 config-dev.yml 配置文件
     * 中的 config:info:"master branch, spring cloud config info"
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}