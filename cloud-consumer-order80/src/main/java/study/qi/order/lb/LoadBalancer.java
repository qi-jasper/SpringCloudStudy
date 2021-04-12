package study.qi.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description 自定义负载均衡算法
 * @Author qi
 * @Date 2021/4/12 14:05
 * @InterfaceName LoadBalancer
 **/
public interface LoadBalancer {

    /**
     * 获取注册的一个实例
     * @param serviceInstances 实例
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}