package domain;

import lombok.Getter;
import lombok.Setter;


/**
 * 描述:
 * 用户信息
 *
 * @author hewm
 * @date 2020 -07-01 14:25:41
 */
@Getter
@Setter
public class User {
    /**
     * 用户编号，自增字段
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 用户登录账号
     */
    private String account;
    /**
     * 用户登录密码
     */
    private char[] password;
    /**
     * 用户权限
     */
    private String privilege;
    /**
     * 上次登录时间
     */
    private String last_login;
}
