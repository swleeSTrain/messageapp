<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="WEB-INF/include/header.jsp"%>
<html>
<head>
    <title>ADMIN WINDOW</title>


</head>
<body>
<%--<c:if test=""var="d">--%>
<iframe  src="/message/send" loading="eager" name="message" width="500" height="500"  >

</iframe>

<form action="/message/send" method="post">
    <button type="submit">SUBMIT</button>
</form>
<%@ include file="WEB-INF/include/header.jsp"%>