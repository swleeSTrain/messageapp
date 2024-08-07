package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.messagewebapp.dao.UserDAO;
import org.example.messagewebapp.vo.UserVO;

import java.io.IOException;
@Log4j2
@WebServlet("/signup")
public class SignupController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("user_id");
        String userName = req.getParameter("user_name");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        UserVO newUser = UserVO.builder()
                .user_id(userId)
                .user_name(userName)
                .password(password)
                .role(role)
                .build();

        try {
            UserDAO.INSTANCE.addUser(newUser);
            resp.sendRedirect("/login");
        } catch (Exception e) {
            log.error("회원가입 오류: ", e);
            req.setAttribute("errorMessage", "회원가입 오류");
            req.getRequestDispatcher("/WEB-INF/user/signup.jsp").forward(req, resp);
        }
    }
}
