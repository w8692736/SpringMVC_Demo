package exception;

/**
 * 描述:
 * 登录异常
 *
 * @author hewm
 * @date 2020-07-02 13:13:19
 */

public class LoginException extends Exception {

    public LoginException(String errorMsg) {
        super(errorMsg);
    }

}
