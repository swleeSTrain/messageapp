<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>

    <h1>전체 쪽지함</h1>

<%--    <c:if test="${messages == null}" var="비어 있음" >--%>
<%--    </c:if>--%>
    <ul class = "list-group">
    <c:forEach items = "${all_messages}" var="message">
        <li class = "list-group">시간:${message.timestamp} 보낸사람:${Csender_id} 받은사람:${message.receiver_id} 내용:${message.message_content}<br></li>
    </c:forEach>
    </ul>


<%@ include file="../include/header.jsp"%>