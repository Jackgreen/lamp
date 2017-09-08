package com.jack.general.account;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @version 2017年09月06日 14:36
 */
@Data
@ToString
public class Account {
    private @Getter @Setter long id;
    private @Getter @Setter
    String userName;
    private @Getter @Setter
    String password;
    private @Getter @Setter
    String realName;
    private @Getter @Setter
    String authoritiesList;
    private @Getter @Setter
    String creator;
    private @Getter @Setter long insertTime;
}
