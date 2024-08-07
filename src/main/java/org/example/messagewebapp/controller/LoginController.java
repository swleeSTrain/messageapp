package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.messagewebapp.dao.UserDAO;
import org.example.messagewebapp.vo.UserVO;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("user_id");
        String password = req.getParameter("password");

        log.info("------------------");
        log.info("user_id: " + user_id);
        log.info("password: " + password);

        try {
            Optional<UserVO> result = UserDAO.INSTANCE.getUsers(user_id,password);
            result.ifPresentOrElse(userVO->{
                Cookie logincookie = new Cookie("user_id", user_id);
                logincookie.setPath("/");
                logincookie.setMaxAge(60*60*24);
                resp.addCookie(logincookie);
                try {
                    resp.sendRedirect("/message/list");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            },() ->{
                try {
                    resp.sendRedirect("/login");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
