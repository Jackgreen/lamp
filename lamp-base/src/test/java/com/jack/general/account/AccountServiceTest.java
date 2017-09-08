package com.jack.general.account;

import com.jack.general.AbsrtactUnitTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.assertTrue;

/**
 * @version 2017年09月08日 10:16
 */
public class AccountServiceTest extends AbsrtactUnitTest {
    @Resource
    private AccountService accountService;

    @Test
    public void testInsert() {
        Account account = new Account();
        account.setUserName("Jack12");
        account.setPassword("1234567");
        account.setRealName("张三");
        account.setAuthoritiesList("test");
        account.setCreator("auto");
        account.setInsertTime(System.currentTimeMillis());
        assertTrue(accountService.insertAccount(account));
    }
}
