<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp"%>
<div class="container text-center">
    <div class="row">
        <div class="col-md-3"><h1>전체쪽지함</h1></div>
        <div class="col-md-9">col-sm-4</div>
    </div>
    <div class="row">
        <div class="col-md-3">
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
        </div>
        <div class="col-md-9">
            <ul>
                <c:forEach var="all_message" items="${all_messages}">
                    <li>
                            ${all_message}
                    </li>
                </c:forEach>
            </ul>
    </div>
</div>



<%@include file="../include/footer.jsp"%>