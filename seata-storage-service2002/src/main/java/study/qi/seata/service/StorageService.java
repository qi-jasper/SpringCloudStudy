package study.qi.seata.service;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/28 14:10
 * @InterfaceName StorageService
 **/
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}