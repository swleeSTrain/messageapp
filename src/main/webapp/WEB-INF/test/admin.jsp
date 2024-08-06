<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>
<html>
<head>
    <title>ADMIN WINDOW</title>


</head>
<body>
<%--<c:if test=""var="d">--%>
<iframe  src="/message/list" loading="eager" name="message" width="500" height="500"  >

</iframe>
<div class="input-group mb-3">
<form action="/test/send" method="post">
    <input type="text" class="form-control">
    <button type="submit" class="btn btn-outline-secondary">SUBMIT</button>
</form>
</div>
<%@ include file="../include/header.jsp"%>