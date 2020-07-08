package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 描述:
 * 数据库连接
 *
 * @author hewm
 * @date 2020 -07-02 14:49:47
 */
public interface BaseDao {

    /**
     * JDBC_DRIVER
     */
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * DB_URL
     */
//    String DB_URL = "jdbc:mysql://localhost:13306/demo" +
//            "?useUnicode=true" +
//            "&characterEncoding=utf-8" +
//            "&useJDBCCompliantTimezoneShift=true" +
//            "&useLegacyDatetimeCode=false" +
//            "&serverTimezone=GMT%2B8";

    String DB_URL = "url=jdbc:mysql://localhost:13306/insurance?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&tinyInt1isBit=false";


    /**
     * 描述:
     *
     * @param account  DB账号
     * @param password DB密码
     * @return connection
     * @throws ClassNotFoundException class not found exception
     * @throws SQLException           sql exception
     * @author hewm
     * @date : 2020-07-02 14:52:31
     */
    Connection getConnection(String account, char[] password) throws ClassNotFoundException, SQLException;

    /**
     * 描述:
     *
     * @param conn  已打开的连接对象
     * @param state 已打开的处理对象
     * @param rs    已打开的数据集
     * @return boolean
     * @throws SQLException sql exception
     * @author hewm
     * @date : 2020-07-02 14:52:31
     */
    boolean closeAll(Connection conn, PreparedStatement state, ResultSet rs) throws SQLException;

    /**
     * 描述:
     *
     * @param conn  已打开的连接对象
     * @param state 已打开的处理对象
     * @return boolean
     * @throws SQLException sql exception
     * @author hewm
     * @date : 2020-07-02 14:52:31
     */
    boolean closeAll(Connection conn, PreparedStatement state) throws SQLException;

    /**
     * 描述:
     * 查询表信息
     *
     * @param sql  查询语句
     * @param conn 已打开的连接类对象
     * @return list
     * @throws SQLException sql exception
     * @author hewm
     * @date : 2020-07-02 15:01:28
     */
    List<?> query(String sql, Connection conn) throws SQLException;

}
