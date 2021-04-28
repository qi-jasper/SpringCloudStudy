package study.qi.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import study.qi.seata.domain.Order;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/28 11:37
 * @InterfaceName OrderDao
 **/
@Mapper
public interface OrderDao {

    /**
     * 1 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 2 修改订单状态，从 0 改为 1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}