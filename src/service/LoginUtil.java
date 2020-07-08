package service;

import exception.LoginException;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

/**
 * 描述:
 *
 * @author hewm
 * @date 2020 -07-02 11:11:17
 */
@Getter
@Setter
public class LoginUtil {

    /**
     * 账号最大长度
     */
    private static Integer MAX_ACCOUNT_LENGTH = 20;
    /**
     * 密码最大长度
     */
    private static Integer MAX_PASSWORD_LENGTH = 20;
    /**
     * 非法字符匹配模式
     */
    private static String ILLEGAL_CHARACTER = "[ _`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\\n|\\r|\\t";

    /**
     * 描述:
     * 判断用户登录时其输入内容是否合法
     *
     * @param account  用户账号
     * @param password 用户密码
     * @return boolean true -
     * @author hewm
     * @date : 2020-07-02 11:13:17
     */
    public static boolean isInputLegal(String account, char[] password) throws LoginException {

        if (isOutOfLength(account)) {
            throw new LoginException("账号超出长度范围");
        } else if (isOutOfLength(String.valueOf(password))) {
            throw new LoginException("密码超出长度范围");
        } else if (account.length() == 0) {
            throw new LoginException("账号不能为空");
        } else if (password.length == 0) {
            throw new LoginException("密码不能为空");
        } else if (isIllegalCharacters(account)) {
            throw new LoginException("账号中存在非法字符");
        }

        return true;
    }

    /**
     * 描述:
     * 检查字符串长度是否超过上限
     *
     * @param str 待检测字符串
     * @return boolean true - 超出长度上限； false - 未超出上限
     * @author hewm
     * @date : 2020-07-02 11:50:42
     */
    private static boolean isOutOfLength(String str) {
        return str.length() > MAX_ACCOUNT_LENGTH;
    }


    /**
     * 描述:
     * 检查字符串中是否有非法字符
     *
     * @param str 待检测字符串
     * @return boolean
     * @author hewm
     * @date : 2020-07-02 11:50:42
     */
    private static boolean isIllegalCharacters(String str) {
        Pattern pattern = Pattern.compile(ILLEGAL_CHARACTER);
        return pattern.matcher(str).find();
    }

}
