package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.messagewebapp.common.CookieUtil;
import org.example.messagewebapp.dao.MessageDAO;
import org.example.messagewebapp.dao.UserDAO;
import org.example.messagewebapp.vo.MessageVO;
import org.example.messagewebapp.vo.UserVO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/message/list")
public class MessageListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie userCookie = CookieUtil.getCookie(req, "user_id");
        if (userCookie == null) {
            resp.sendRedirect("/login");
        }
        String user_id = userCookie.getValue();
        try {
            Optional<UserVO> userOpt = UserDAO.INSTANCE.getUserById(user_id);
            if (userOpt.isEmpty()) {
                resp.sendRedirect("/login");
            }
            UserVO user = userOpt.get();
            List<UserVO> students;
            if ("ADMIN".equals(user.getRole())) {
                students = UserDAO.INSTANCE.getAllUsers();
            } else {
                students = UserDAO.INSTANCE.getStudentsByRoom(String.valueOf(user.getRoom_no()));
            }
            req.setAttribute("students", students);
            req.setAttribute("user", user);
            List<MessageVO> all_messages = MessageDAO.INSTANCE.getAllMessages(user_id);
            req.setAttribute("all_messages", all_messages);
            req.getRequestDispatcher("/WEB-INF/message/list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
