package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.messagewebapp.dao.RoomDAO;

import java.io.IOException;

@WebServlet("/room/delete")
public class RoomDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int room_no = Integer.parseInt(req.getParameter("room_no"));
            RoomDAO.INSTANCE.deleteRoom(room_no);
            resp.sendRedirect("/room/list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
