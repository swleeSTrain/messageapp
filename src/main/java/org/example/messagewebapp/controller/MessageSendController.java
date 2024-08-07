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
import org.example.messagewebapp.dao.RoomDAO;
import org.example.messagewebapp.dao.UserDAO;
import org.example.messagewebapp.vo.MessageVO;
import org.example.messagewebapp.vo.UserVO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Log4j2
@WebServlet("/message/send")
public class MessageSendController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie userCookie = CookieUtil.getCookie(req, "user_id");
        if (userCookie == null) {
            resp.sendRedirect("/login");
        }
        String user_id = userCookie.getValue();
        String receiver_id = req.getParameter("receiver_id");
        String messageContent = req.getParameter("message_content");

        MessageVO message = MessageVO.builder()
                .sender_id(user_id)
                .receiver_id(receiver_id)
                .message_content(messageContent)
                .build();
        try {
            MessageDAO.INSTANCE.sendMessage(message);
            resp.sendRedirect("/message/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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
            String room_name = RoomDAO.INSTANCE.getRoomNameByNo(user.getRoom_no());
            req.setAttribute("room_name", room_name);
            req.setAttribute("students", students);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/message/send.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
