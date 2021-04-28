package study.qi.seata.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.qi.seata.dao.StorageDao;
import study.qi.seata.service.StorageService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/28 14:11
 * @ClassName StorageServiceImpl
 **/
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("------->storage-service中扣减库存结束");
    }
}