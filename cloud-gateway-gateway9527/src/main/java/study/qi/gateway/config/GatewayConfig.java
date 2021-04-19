package study.qi.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/19 10:40
 * @ClassName GatewayConfig
 **/
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个 id 为 route-name 的路由规则，当访问地址 http://localhost:9527/guonei 时，
     * 会自动转发到地址 http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // id 即 YAML 配置文件中配置的 id
        routes.route("path route guonei",
                // URI 即转发到的服务地址，path 即请求的本地服务接口接口
                // 所以当前请求 localhost:9527/guonei 后会自动跳转到 https://www.baidu.com/guonei
                r -> r.path("/guonei").uri("https://www.baidu.com/guonei")).build();

        return routes.build();
    }

}