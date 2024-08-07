<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp"%>
<div class="col-md-9">
    <div class="container">
        <h1 class="mt-4">받은 쪽지함</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>시간</th>
                <th>보낸사람</th>
                <th>받은사람</th>
                <th>내용</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="receive_message" items="${receive_messages}">
                <tr>
                    <td>${receive_message.timestamp}</td>
                    <td>${receive_message.sender_id}</td>
                    <td>${receive_message.receiver_id}</td>
                    <td>${receive_message.message_content}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

<%@include file="../include/footer.jsp"%>
