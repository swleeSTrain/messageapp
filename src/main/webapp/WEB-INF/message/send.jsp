<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp"%>
<h1>새 쪽지 보내기</h1>
<div class="mb-3">
    <label class="form-label">보내는 사람</label>
    <p>${user.user_name} (${user.user_id})</p>
</div>
<form action="/message/send" method="post">
    <label>받는 ID:</label>
    <select id="receiver_id" name="receiver_id" required>
        <!-- 관리자일 경우 '전체' 옵션 추가 -->
        <c:if test="${user.role eq 'ADMIN'}">
            <option value="전체">전체</option>
        </c:if>
        <!-- 학생 목록: 자신의 반 학생들만 표시 -->
        <c:forEach var="student" items="${students}">
            <option value="${student.user_id}">${student.user_name}</option>
        </c:forEach>
    </select>
    <label>내용:</label>
    <input type="text" id="message_content" name="message_content">
    <input type="submit" value="Send">
</form>
</div>
</div>
<%@include file="../include/footer.jsp"%>
