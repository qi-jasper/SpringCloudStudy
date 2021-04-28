package study.qi.seata.service;

import study.qi.seata.domain.Order;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/28 11:45
 * @InterfaceName OrderService
 **/
public interface OrderService {
    void create(Order order);
}