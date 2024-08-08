package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.messagewebapp.common.CookieUtil;
import org.example.messagewebapp.dao.MessageDAO;
import org.example.messagewebapp.dao.UserDAO;
import org.example.messagewebapp.vo.MessageVO;
import org.example.messagewebapp.vo.UserVO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Log4j2
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
            //내가 추가한 똑같은 students 값들
            List<UserVO> allUsers = UserDAO.INSTANCE.getAllUsers();
            List<UserVO> students;
            if ("ADMIN".equals(user.getRole())) {
                students = UserDAO.INSTANCE.getAllUsers();
            } else {
                students = allUsers.stream().filter(student -> {
                    return student.getRoom_no().equals(user.getRoom_no());
                }).toList();
                students.stream().forEach(student -> {
                    log.info("student" + student.getUser_no() + ": " + student.getRoom_no());
                });
            }
            req.setAttribute("user", user);
            req.setAttribute("students", students);
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
