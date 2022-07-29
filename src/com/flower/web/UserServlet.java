package com.flower.web;

import com.flower.pojo.User;
import com.flower.service.UserService;
import com.flower.service.impl.UserServiceImpl;
import com.flower.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null) {
            req.setAttribute("msg1","账号或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("pages/signin.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user",loginUser);
            req.getSession().setAttribute("username",username);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User user= WebUtils.copyPaeamToBean(req.getParameterMap(),new User());

        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.removeAttribute(KAPTCHA_SESSION_KEY);
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                req.setAttribute("msg2","账号已存在");
                req.setAttribute("email",email);
                req.getRequestDispatcher("pages/signout.jsp").forward(req, resp);

            } else {
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("pages/signin.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg2","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("pages/signout.jsp").forward(req, resp);
        }
    }

    protected void UpdateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void UpdateUserPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }




    }