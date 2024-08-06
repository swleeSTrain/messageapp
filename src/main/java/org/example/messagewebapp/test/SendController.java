package org.example.messagewebapp.test;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@WebServlet(value="/message/send")
public class SendController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "하이요");
        req.getRequestDispatcher("/get.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "하이요");
        List<String > list = new ArrayList<>();
        list.add("hi");
        list.add("hello");
        list.add("my name is ds");
        list.add("see you later");
        req.setAttribute("messages", list);
        resp.sendRedirect("/message/get");
    }
}
