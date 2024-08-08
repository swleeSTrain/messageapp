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

<div class="container text-center">
    <div class="row">
        <div class="col-md-3" style="margin-top: 30px"><h1>쪽지시스템</h1></div>
        <div class="col-md-6"></div>
        <div class="col-md-3">
            <form action="/logout" method="get">
                <button type="submit">로그아웃</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3" >
            <form action="/message/list" method="get" >
                <button type="submit" class="btn btn-outline-secondary">전체 쪽지함</button>
            </form>
            <form action="/message/sendlist" method="get" >
                <button type="submit" class="btn btn-outline-secondary">보낸 쪽지함</button>
            </form>
            <form action="/message/recivelist" method="get">
                <button type="submit" class="btn btn-outline-secondary" >받은 쪽지함</button>
            </form>
            <c:if test="${user.role eq 'ADMIN'}">
                <form action="/room/add" method="get">
                    <button type="submit" class="btn btn-outline-secondary" >방추가</button>
                </form>
                <form action="/room/assign" method="get">
                    <button type="submit" class="btn btn-outline-secondary" >방인원수정</button>
                </form>
                <form action="/room/list" method="get">
                    <button type="submit" class="btn btn-outline-secondary">방목록</button>
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
<%--                        <div class="input-group mb-3" style="width: 500px">--%>
<%--                            <label for="sender_id" class="label-standard" >받는 사람: </label>--%>
<%--                            <input type="text" class="form-control" name="sender_id" id="sender_id" aria-label="Message Content" aria-describedby="button-addon2" placeholder="Receiver ID" name="message_content" id="message_content" >--%>
<%--                        </div>--%>


                        <div class="input-group mb-3" style="width: 800px" >
                            <label class="label-standard" >받는 ID:</label>
                            <select id="receiver_id" name="receiver_id" required style="margin-right: 20px">
                                <!-- 관리자일 경우 '전체' 옵션 추가 -->
                                <c:if test="${user.role eq 'ADMIN'}">
                                    <option value="전체">전체</option>
                                </c:if>
                                <!-- 학생 목록: 자신의 반 학생들만 표시 -->
                                <c:forEach var="student" items="${students}">
                                    <option value="${student.user_id}">${student.user_name}</option>
                                </c:forEach>
                            </select>
                                <label for= "message_content" class="label-standard">메시지 내용: </label>
                                <input type="text" class="form-control"  aria-label="Message Content" aria-describedby="button-addon2" placeholder="Message Content" name="message_content" id="message_content" >
                            <button class="btn btn-outline-secondary" type="submit" id="button-addon2" style="margin-right: 25px">보내기</button>
                        </div>

                    </form>
                </div>
        </div>



</div>



<%@include file="../include/footer.jsp"%>