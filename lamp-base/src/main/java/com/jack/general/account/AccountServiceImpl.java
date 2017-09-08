package com.jack.general.account;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @version 2017年09月06日 15:59
 */
@Component(value = "accountService")
public class AccountServiceImpl implements AccountService{
    private static final Logger logger = LogManager.getLogger();
    @Resource
    private AccountDao accountDao;

    public Account getAccountById(long id) {
        return accountDao.getAccountById(id);
    }

    public boolean insertAccount(Account account) {
        return accountDao.insertAccount(account);
    }

    public boolean deleteAccountById(long id) {
        return accountDao.deleteAccountById(id);
    }

    public boolean updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }
}
