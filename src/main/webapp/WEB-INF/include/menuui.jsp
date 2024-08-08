
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp"%>

<div class="container text-center">
    <div class="row">
        <div class="col-md-3" style="margin-top: 30px"><h1>쪽지시스템</h1></div>
        <div class="col-md-6"></div>
        <div class="col-md-3">
            <form action="/logout" method="get">
                <button type="submit">로그아웃</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3" >
            <form action="/message/send" method="get" style="margin-top: 25px" >
                <button type="submit" class="btn btn-outline-secondary">새 쪽지 보내기</button>
            </form>
            <form action="/message/list" method="get" >
                <button type="submit" class="btn btn-outline-secondary">전체 쪽지함</button>
            </form>
            <form action="/message/sendlist" method="get" >
                <button type="submit" class="btn btn-outline-secondary">보낸 쪽지함</button>
            </form>
            <form action="/message/recivelist" method="get">
                <button type="submit" class="btn btn-outline-secondary" >받은 쪽지함</button>
            </form>
            <c:if test="${user.role eq 'ADMIN'}">
                <form action="/room/add" method="get">
                    <button type="submit" class="btn btn-outline-secondary" >방추가</button>
                </form>
                <form action="/room/assign" method="get">
                    <button type="submit" class="btn btn-outline-secondary" >방인원수정</button>
                </form>
                <form action="/room/list" method="get">
                    <button type="submit" class="btn btn-outline-secondary">방목록</button>
                </form>
            </c:if>
        </div>