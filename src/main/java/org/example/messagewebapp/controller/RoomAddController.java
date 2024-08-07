package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.messagewebapp.common.CookieUtil;
import org.example.messagewebapp.dao.RoomDAO;
import org.example.messagewebapp.dao.UserDAO;
import org.example.messagewebapp.vo.RoomVO;
import org.example.messagewebapp.vo.UserVO;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/room/add")
public class RoomAddController extends HttpServlet {
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
            req.setAttribute("user", user);
            if (!"ADMIN".equals(user.getRole())) {
                resp.sendRedirect("/login");  // 접근 권한이 없는 경우 리다이렉트
            }
            req.getRequestDispatcher("/WEB-INF/room/add.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
