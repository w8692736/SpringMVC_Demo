package dao;

import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author hewm
 * @date 2020 -07-02 14:54:21
 */
@Getter
public class UserDao implements dao.BaseDao {

    /**
     * COL_ID
     */
    private static String COL_ID = "ID";
    /**
     * COL_NAME
     */
    private static String COL_NAME = "NAME";
    /**
     * COL_ACCOUNT
     */
    private static String COL_ACCOUNT = "ACCOUNT";
    /**
     * COL_PASSWORD
     */
    private static String COL_PASSWORD = "PASSWORD";
    /**
     * COL_PRIVILEGE
     */
    private static String COL_PRIVILEGE = "PRIVILEGE";
    /**
     * COL_LAST_LOGIN
     */
    private static String COL_LAST_LOGIN = "LAST_LOGIN";

    /**
     * 描述:
     *
     * @param account  DB账号
     * @param password DB密码
     * @return connection
     * @author hewm
     * @date : 2020-07-02 14:52:31
     */
    @Override
    public Connection getConnection(String account, char[] password) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, account, String.valueOf(password));
    }

    /**
     * 描述:
     * 关闭已打开的连接对象
     *
     * @param conn  已打开的连接对象
     * @param state 已打开的处理对象
     * @param rs    已打开的数据集
     * @return boolean
     * @author hewm
     * @date : 2020-07-02 14:52:31
     */
    @Override
    public boolean closeAll(Connection conn, PreparedStatement state, ResultSet rs) throws SQLException {
        conn.close();
        state.close();
        rs.close();

        return false;
    }

    /**
     * 描述:
     *
     * @param conn  已打开的连接对象
     * @param state 已打开的处理对象
     * @return boolean
     * @author hewm
     * @date : 2020-07-02 14:52:31
     */
    @Override
    public boolean closeAll(Connection conn, PreparedStatement state) throws SQLException {
        conn.close();
        state.close();

        return false;
    }

    /**
     * 描述:
     * 查询表信息
     *
     * @param sql 查询语句
     * @return list
     * @author hewm
     * @date : 2020-07-02 15:01:28
     */
    @Override
    public List<domain.User> query(String sql, Connection conn) throws SQLException {
        PreparedStatement state = conn.prepareStatement(sql);
        ResultSet rs = state.executeQuery();

        List<domain.User> list = new ArrayList<>();
        while (rs.next()) {
            domain.User user = new domain.User();

            user.setId(rs.getString(COL_ID));
            user.setName(rs.getString(COL_NAME));
            user.setAccount(rs.getString(COL_ACCOUNT));
            user.setPassword(rs.getString(COL_PASSWORD).toCharArray());
            user.setPrivilege(rs.getString(COL_PRIVILEGE));
            user.setLast_login(rs.getString(COL_LAST_LOGIN));

            list.add(user);
        }

        closeAll(conn, state, rs);

        return list;
    }
}
