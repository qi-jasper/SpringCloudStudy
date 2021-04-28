package study.qi.seata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.qi.entities.CommonResult;
import study.qi.seata.domain.Order;
import study.qi.seata.service.OrderService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/28 13:46
 * @ClassName OrderController
 **/
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}