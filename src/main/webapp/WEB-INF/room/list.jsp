<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../include/header.jsp" %>

<div class="container">
    <h1 class="mt-4">방 목록</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>방 번호</th>
            <th>방 이름</th>
            <th>액션</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td>${room.room_no}</td>
                <td>${room.room_name}</td>
                <td>
                    <form action="/room/delete" method="get" style="display:inline;">
                        <input type="hidden" name="room_no" value="${room.room_no}">
                        <button type="submit" class="btn btn-danger">삭제</button>
                    </form>
                    <form action="/room/assign" method="get" style="display:inline;">
                        <input type="hidden" name="room_no" value="${room.room_no}">
                        <button type="submit" class="btn btn-secondary">학생 배정</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="/room/add" method="get">
        <button type="submit" class="btn btn-primary">방 추가</button>
    </form>
</div>

<%@ include file="../include/footer.jsp" %>
