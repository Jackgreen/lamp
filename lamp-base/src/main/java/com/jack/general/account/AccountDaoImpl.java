package com.jack.general.account;

import com.jack.general.abst.AbstractDao;
import org.springframework.stereotype.Component;



/**
 * @version 2017年09月06日 15:36
 */
@Component(value = "accountDao")
public class AccountDaoImpl extends AbstractDao implements AccountDao{
    public Account getAccountById(long id) {
        Object ret = getSqlSessionTemplate().selectOne(ACCOUNTMAPPER + "getById", id);
        if (ret != null) {
            Account account = (Account) ret;
            return account;
        } else {
            return null;
        }
    }

    public boolean insertAccount(Account account) {
        return getSqlSessionTemplate().insert(ACCOUNTMAPPER + "insert", account) == 1 ? true : false;
    }

    public boolean deleteAccountById(long id) {
        return getSqlSessionTemplate().delete(ACCOUNTMAPPER + "deleteById", id) == 1 ? true : false;
    }

    public boolean updateAccount(Account account) {
        return getSqlSessionTemplate().update(ACCOUNTMAPPER + "update", account) == 1 ? true : false;
    }
}
