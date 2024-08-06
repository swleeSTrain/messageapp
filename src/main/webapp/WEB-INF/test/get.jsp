<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>

    <h1>COMMON DATA</h1>

<%--    <c:if test="${messages == null}" var="비어 있음" >--%>
<%--    </c:if>--%>
    <ul>
    <c:forEach items = "${messages}" var="message">
        ${message}
    </c:forEach>
    </ul>


<%@ include file="../include/header.jsp"%>