package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.messagewebapp.dao.RoomDAO;
import org.example.messagewebapp.vo.RoomVO;

import java.io.IOException;

@WebServlet("/room/add")
public class RoomAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/room/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String room_name = req.getParameter("room_name");
            RoomVO room = RoomVO.builder()
                    .room_name(room_name)
                    .build();
            RoomDAO.INSTANCE.addRoom(room);
            resp.sendRedirect("list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
