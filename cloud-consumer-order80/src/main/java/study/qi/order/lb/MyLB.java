package study.qi.order.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/12 14:16
 * @ClassName MyLB
 **/
@Component
public class MyLB implements LoadBalancer {

    /**
     * 创建原子整型类型
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;
        // 自旋锁
        do {
            current = this.atomicInteger.get();
            // 发生越界，从0开始计数
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            // 比较并交换
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问： " + next);

        return next;
    }

    /**
     * 负载均衡算法：第几次请求 % 服务器总数量 = 实际访问。服务每次启动从 1 开始
     * @param serviceInstances 实例
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 获取当前计数 模  实例总数
        int index= getAndIncrement() % serviceInstances.size();

        // 返回选择的实例
        return serviceInstances.get(index);
    }
}