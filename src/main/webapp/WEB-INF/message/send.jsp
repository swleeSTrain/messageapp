
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp"%>

<h1>
    메시지 전송페이지
</h1>
<form action="/message/send" method="post" class="input-group mb-3">
    <label>보내는 ID:</label>
    <input type="text" id="sender_id" name="sender_id" class="form-control">
    <label>받는 ID:</label>
    <input type="text" id="receiver_id" name="receiver_id" class="form-control">
    <label>내용:</label>
    <input type="text" id="message_content" name="message_content" class="form-control">
    <input class="btn btn-outline-secondary" type="submit" value="Send">
</form>
<%--<div >--%>
<%--    <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">--%>
<%--    <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>--%>
<%--</div>--%>