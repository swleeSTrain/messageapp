package org.example.messagewebapp.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.messagewebapp.dao.MessageDAO;
import org.example.messagewebapp.vo.MessageVO;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/message/get")
public class MessageViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user_id = req.getParameter("user_id");
        try {
            List<MessageVO> all_messages = MessageDAO.INSTANCE.getAllMessage("std1");
            req.setAttribute("all_messages", all_messages);
            req.getRequestDispatcher("/WEB-INF/test/get.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
