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
import java.util.List;
@WebServlet("/message/sendlist")
@Log4j2
public class MessageSendListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("user_id");
        try {
            List<MessageVO> send_messages = MessageDAO.INSTANCE.getSendMessage("std1");
            req.setAttribute("send_messages", send_messages);
            req.getRequestDispatcher("/WEB-INF/message/sendlist.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
