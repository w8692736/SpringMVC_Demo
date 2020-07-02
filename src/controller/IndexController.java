package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 描述:
 *
 * @author hewm
 * @date 2020 -07-01 13:43:00
 */
@Controller
public class IndexController {

    /**
     * 描述:
     *
     * @param session
     * @return model and view
     * @author hewm
     * @date : 2020-07-01 17:15:40
     */
    @RequestMapping("/login")
    public ModelAndView goLogin(HttpSession session) {
        ModelAndView view = new ModelAndView("site/homepage");

        // 查看是否有保存登录信息
        domain.User currentUser = (domain.User) session.getAttribute("currentUser");
        if (null != currentUser) {
            return view;
        }


        view = new ModelAndView("login");
        view.addObject("message", "[action: login]");
        view.addObject("title", "登录界面");

        return view;
    }

    /**
     * 描述:
     *
     * @return model and view
     * @author hewm
     * @date : 2020-07-01 17:15:40
     */
    @RequestMapping("/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView("index");
        view.addObject("message", "[action: index]");
        view.addObject("title", "Index");

        return view;
    }

    /**
     * 描述:
     *
     * @return model and view
     * @author hewm
     * @date : 2020-07-01 17:15:40
     */
    @RequestMapping("header")
    public ModelAndView header() {
        return new ModelAndView("header");
    }

}
