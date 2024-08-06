package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.messagewebapp.dao.UserDAO;
import org.example.messagewebapp.vo.UserVO;

import java.io.IOException;
import java.util.List;

@WebServlet("/room/assign")
public class RoomAssignController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<UserVO> students = UserDAO.INSTANCE.getAllStudents();
            req.setAttribute("students", students);
            req.setAttribute("room_no", req.getParameter("room_no"));
            req.getRequestDispatcher("/WEB-INF/room/assign.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int roomNo = Integer.parseInt(req.getParameter("room_no"));
            String studentId = req.getParameter("student_id");
            UserDAO.INSTANCE.assignRoom(studentId, roomNo);
            resp.sendRedirect("list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
