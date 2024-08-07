package org.example.messagewebapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 쿠키삭제 위해서 새쿠키 생성후 값 비우고 시간만료시키기.
        Cookie userCookie = new Cookie("user_id", null);
        userCookie.setMaxAge(0); // 쿠키를 즉시 만료시키기 위해 0으로 설정
        userCookie.setPath("/"); // 모든 경로 쿠키를 삭제

        // 쿠키를 응답에 추가하여 클라이언트에 전송
        resp.addCookie(userCookie);

        // 로그아웃 후 로그인 페이지로 리다이렉트
        resp.sendRedirect("/login");
    }
}
