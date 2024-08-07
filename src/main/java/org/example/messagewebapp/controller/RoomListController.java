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
import java.util.List;
import java.util.Optional;

@WebServlet("/room/list")
public class RoomListController extends HttpServlet {
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
            try {
                List<RoomVO> rooms = RoomDAO.INSTANCE.getAllRooms();
                req.setAttribute("rooms", rooms);
                req.getRequestDispatcher("/WEB-INF/room/list.jsp").forward(req, resp);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
