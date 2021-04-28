package study.qi.seata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.qi.entities.CommonResult;
import study.qi.seata.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description
 * @Author qi
 * @Date 2021/4/28 14:04
 * @ClassName AccountController
 **/
public class AccountController {
    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);

        return new CommonResult(200, "扣减账户余额成功！");
    }
}