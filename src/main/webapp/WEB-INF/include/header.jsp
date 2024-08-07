
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container text-center">
    <div class="row">
        <div class="col-md-3"><h1>쪽지시스템</h1></div>
        <div class="col-md-6">
            <h2>현재 방: ${room_name}</h2>
        </div>
        <div class="col-md-3">
            <form action="/logout" method="get">
                <button type="submit">로그아웃</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <form action="/message/send" method="get">
                <button type="submit">새 쪽지 보내기</button>
            </form>
            <form action="/message/list" method="get">
                <button type="submit">전체 쪽지함</button>
            </form>
            <form action="/message/sendlist" method="get">
                <button type="submit">보낸 쪽지함</button>
            </form>
            <form action="/message/receivelist" method="get">
                <button type="submit">받은 쪽지함</button>
            </form>
            <c:if test="${user.role eq 'ADMIN'}">
                <form action="/room/add" method="get">
                    <button type="submit">방추가</button>
                </form>
                <form action="/room/list" method="get">
                    <button type="submit">방목록</button>
                </form>
            </c:if>
        </div>
        <div class="col-md-9">