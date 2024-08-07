<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp"%>

<style>
    .label-standard{
        margin-left: 150px;
        align-content: center;
        padding-right: 10px;
    }

    .iframe-standard{
        width: 700px;
        height: 400px;
        border: 2px solid;


    }
</style>


<%--<c:set var="cookies" value="${pageContext.request.cookies}">--%>
<%--</c:set>--%>
<%--<c:if test="${not empty cookies}">--%>
<%--    <c:forEach var="cookie" items="${cookies}">--%>
<%--        <c:set var="${cookie.name}" value="${cookie.value}"></c:set>--%>
<%--        <li>${cookie.name}: ${cookie.value}</li>--%>
<%--    </c:forEach>--%>
<%--</c:if>--%>
<div class="container text-center">
    <div class="row">
        <div class="col-md-3" style="margin-top: 100px"><h1>< 기능 버튼 ></h1></div>
        <div class="col-md-9"></div>
    </div>
    <div class="row">
        <div class="col-md-3" >
            <form action="/message/send" method="get" style="margin-top: 25px" >
                <button type="submit" class="btn btn-outline-secondary">새 쪽지 보내기</button>
            </form>
            <form action="/message/list" method="get" >
                <button type="submit" class="btn btn-outline-secondary">전체 쪽지함</button>
            </form>
            <form action="/message/sendlist" method="get" >
                <button type="submit" class="btn btn-outline-secondary">보낸 쪽지함</button>
            </form>
            <form action="/message/recivelist" method="get">
                <button type="submit" class="btn btn-outline-secondary" >받은 쪽지함</button>
            </form>
            <c:if test="${logincookie.value eq 'ADMIN'}">
                <form action="/message/" method="get">
                    <button type="submit" class="btn btn-outline-secondary" >전체 쪽지 보내기</button>
                </form>
                <form action="/message/" method="get">
                    <button type="submit" class="btn btn-outline-secondary" >방 생성</button>
                </form>
                <form action="/message/" method="get">
                    <button type="submit" class="btn btn-outline-secondary" >방 변경</button>
                </form>
            </c:if>

        </div>
        <div class="col-md-9">
            <c:if test="${recive_messages != null}" >
                <iframe src="/message/receive_get"  loading="eager" class="iframe-standard">
                </iframe>
            </c:if>
            <c:if test="${send_messages != null}" >
                <iframe src="/message/send_get"  loading="eager" class="iframe-standard">
                </iframe>
            </c:if>
            <c:if test="${send_messages == null && recive_messages == null }">
                <iframe src="/message/get"  loading="eager" class="iframe-standard" >
                </iframe>
            </c:if>

    </div>
        <div class="row">
            <div class="col-md-3">`
            </div>
                <div class="col-md-9">
                    <form action="/message/send" method="post" style="margin-top: 40px">
                        <div class="input-group mb-3" style="width: 500px">
                            <label for="sender_id" class="label-standard" >받는 사람: </label>
                            <input type="text" class="form-control" name="sender_id" id="sender_id" aria-label="Message Content" aria-describedby="button-addon2" placeholder="Receiver ID" name="message_content" id="message_content" >
                        </div>
                            <div class="input-group mb-3"style="width: 800px">
                                <label for= "message_content" class="label-standard">메시지 내용: </label>
                                <input type="text" class="form-control"  aria-label="Message Content" aria-describedby="button-addon2" placeholder="Message Content" name="message_content" id="message_content" >
                            <button class="btn btn-outline-secondary" type="submit" id="button-addon2">보내기</button>
                        </div>

                    </form>
                </div>
        </div>



</div>



<%@include file="../include/footer.jsp"%>