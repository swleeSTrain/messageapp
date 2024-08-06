<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp"%>
<h1>보낸쪽지함</h1>
<ul>
    <c:forEach var="send_message" items="${send_messages}">
        <li>
                ${send_message}
        </li>
    </c:forEach>
</ul>
<form action="/message/send" method="get">
    <button type="submit">새 쪽지 보내기</button>
</form>
<form action="/message/list" method="get">
    <button type="submit">전체 쪽지함</button>
</form>
<form action="/message/sendlist" method="get">
    <button type="submit">보낸 쪽지함</button>
</form>
<form action="/message/recivelist" method="get">
    <button type="submit">받은 쪽지함</button>
</form>
<%@include file="../include/footer.jsp"%>
