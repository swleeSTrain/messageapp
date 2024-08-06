package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.messagewebapp.dao.RoomDAO;
import org.example.messagewebapp.vo.RoomVO;

import java.io.IOException;
import java.util.List;

@WebServlet("/room/list")
public class RoomListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<RoomVO> rooms = RoomDAO.INSTANCE.getAllRooms();
            req.setAttribute("rooms", rooms);
            req.getRequestDispatcher("/WEB-INF/room/list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
