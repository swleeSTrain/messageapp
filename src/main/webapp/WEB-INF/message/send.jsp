<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp"%>
<h1>
    메시지 전송페이지
</h1>
<form action="/message/send" method="post">
    <label>보내는 ID:</label>
    <input type="text" id="sender_id" name="sender_id">
    <label>받는 ID:</label>
    <input type="text" id="receiver_id" name="receiver_id">
    <label>내용:</label>
    <input type="text" id="message_content" name="message_content">
    <input type="submit" value="Send">
</form>
<%@include file="../include/footer.jsp"%>
