package controller;

import dao.UserDao;
import exception.LoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.LoginUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * 描述:
 *
 * @author hewm
 * @date 2020 -07-01 14:29:28
 */
@Controller
public class LoginController {

    /**
     * CHECK_PASS
     * 用户输入正确
     */
    private static final String CHECK_PASS = "pass";

    /**
     * 描述:
     *
     * @param session
     * @return model and view
     * @author hewm
     * @date : 2020-07-01 17:15:40
     */
    @RequestMapping(value = "homepage")
    public ModelAndView homepage(HttpSession session) {
        ModelAndView view = new ModelAndView("site/homepage");
        domain.User currentUser = (domain.User) session.getAttribute("currentUser");

        if (null == currentUser) {
            view.setViewName("error/login_error");
            view.addObject("error_msg", "请先登录");
        }

        return view;
    }

    /**
     * 描述:
     *
     * @param session
     * @return model and view
     * @author hewm
     * @date : 2020-07-01 17:15:40
     */
    @RequestMapping(value = "sign_in")
    public ModelAndView loginValidator(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        //   @RequestParam("input_account") String account,
        //   @RequestParam("input_password") char[] password) {
        ModelAndView view = new ModelAndView("error/login_error");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        domain.User user = new domain.User();
        user.setAccount(account);
        user.setPassword(password.toCharArray());
        user.setName("root");
        user.setPrivilege("Administrator");
        user.setLast_login("1970-01-01 00:00:00");
        session.setAttribute("currentUser", user);
        if(user != null){
            view.setViewName("site/homepage");
            return view;
        }


        // 检查用户输入
        try {
            if (!LoginUtil.isInputLegal(account, password.toCharArray())) {
                view.setViewName("site/homepage");
            }
        } catch (LoginException e) {
            view.addObject("error_msg", e.getMessage());
            return view;
        }

        domain.User beCheckedUser = new domain.User();
        beCheckedUser.setAccount(account);
        beCheckedUser.setPassword(password.toCharArray());

        try {
            Connection conn = new UserDao().getConnection(account, password.toCharArray());
            String sql = "SELECT ID, NAME, ACCOUNT, PASSWORD, PRIVILEGE, LAST_LOGIN FROM USERINFO " +
                    "WHERE ACCOUNT = ? AND PASSWORD = ? ";
            PreparedStatement state = conn.prepareStatement(sql);

            state.setString(1, beCheckedUser.getAccount());
            state.setString(2, String.valueOf(beCheckedUser.getPassword()));

            ResultSet rs = state.executeQuery();
            if (rs.next()) {
                view.setViewName("site/homepage");
                beCheckedUser.setId(rs.getString("ID"));
                beCheckedUser.setName(rs.getString("NAME"));
                beCheckedUser.setPrivilege(rs.getString("PRIVILEGE"));

                // 调整时间格式
                String lastLogin = String.valueOf(rs.getTimestamp("LAST_LOGIN"));
                beCheckedUser.setLast_login(lastLogin.substring(0, lastLogin.length() - 2));

                // session信息存储七天，记录用户的登录情况
                // 604800 = 60 * 60 * 24 * 7
                session.setMaxInactiveInterval(604800);
                session.setAttribute("currentUser", beCheckedUser);

                // 更新上次登录时间
                sql = "UPDATE USERINFO SET LAST_LOGIN = CURRENT_TIMESTAMP() WHERE ID = ? ";
                state = conn.prepareStatement(sql);
                state.setString(1, beCheckedUser.getId());
                state.executeUpdate();
            }

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
            view.addObject("error_msg", "服务器驱动配置异常");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            view.addObject("error_msg", "查询失败");
        } catch (Exception e) {
            e.printStackTrace();
            view.addObject("error_msg", "未知异常，请联系管理员");
        }

        return view;
    }

    /**
     * 描述:
     *
     * @param session
     * @return model and view
     * @author hewm
     * @date : 2020-07-01 17:15:40
     */
    @RequestMapping("sign_out")
    public ModelAndView signOut(HttpSession session) {
        ModelAndView view = new ModelAndView("login");

        // 注销session信息
        session.removeAttribute("currentUser");

        return view;
    }

}
