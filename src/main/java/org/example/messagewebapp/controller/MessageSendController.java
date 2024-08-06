package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.messagewebapp.dao.MessageDAO;
import org.example.messagewebapp.vo.MessageVO;

import java.io.IOException;

@Log4j2
@WebServlet("/message/send")
public class MessageSendController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sender_id = req.getParameter("sender_id");
        String receiver_id = req.getParameter("receiver_id");
        String messageContent = req.getParameter("message_content");

        MessageVO message = MessageVO.builder()
                .sender_id(sender_id)
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
        req.getRequestDispatcher("/WEB-INF/message/send.jsp").forward(req, resp);
    }
}
