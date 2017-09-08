package com.jack.general.account;

/**
 * @version 2017年09月06日 15:58
 */
public interface AccountService {
    /**
     * 根据通行证获取帐号信息
     * @param id
     * @return
     */
    public Account getAccountById(long id);

    /**
     * 插入帐号信息
     * @param account
     * @return
     */
    public boolean insertAccount(Account account);

    /**
     * 删除帐号
     * @param id
     * @return
     */
    public boolean deleteAccountById(long id);

    /**
     * 更新帐号信息
     * @param account
     * @return
     */
    public boolean updateAccount(Account account);
}
