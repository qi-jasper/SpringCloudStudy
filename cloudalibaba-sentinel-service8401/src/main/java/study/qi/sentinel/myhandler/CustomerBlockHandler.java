package study.qi.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import study.qi.entities.CommonResult;

/**
 * @Description 自定义处理方法
 * @Author qi
 * @Date 2021/4/27 20:00
 * @ClassName CustomerBlockHandler
 **/
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }


    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }

}