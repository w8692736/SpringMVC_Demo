package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 描述:
 *
 * @author hewm
 * @date 2020 -06-29 15:38:32
 */
public class SqlConnector {

    /**
     * 驱动名
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 连接字符串 MySQL
     */
    private static final String DB_URL = "jdbc:mysql://localhost:13306/demo" +
            "?useUnicode=true" +
            "&characterEncoding=utf-8" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=GMT%2B8";

    /**
     * 描述:
     * 创建数据库连接对象，账号密码由用户在login页面上输入
     *
     * @param account  访问数据库用的账号
     * @param password 访问数据库用的密码
     * @return connection
     * @throws ClassNotFoundException class not found exception
     * @throws SQLException           sql exception 账号或密码有误的时候抛出此异常
     * @author hewm
     * @date : 2020-06-29 15:46:44
     */
    public Connection getConnection(String account, char[] password) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, account, String.valueOf(password));
    }

}
