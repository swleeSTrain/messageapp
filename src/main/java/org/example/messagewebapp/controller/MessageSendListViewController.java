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

@WebServlet(value="/message/send_get")
@Log4j2
public class MessageSendListViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie userCookie = CookieUtil.getCookie(req, "user_id");
        if (userCookie == null) {
            resp.sendRedirect("/login");
        }
        String user_id = userCookie.getValue();
        try {
            List<MessageVO> all_messages = MessageDAO.INSTANCE.getSendMessage(user_id);
            req.setAttribute("send_messages", all_messages);
            req.getRequestDispatcher("/WEB-INF/message/sendlist.jsp").forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

}
