<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="./include/header.jsp" %>
<div class="container text-center">
    <div class="row">
        <div class="col-6 col-md-3"></div>
        <div class="col-6 col-md-6"><h1>로그인 페이지</h1></div>
        <div class="col-6 col-md-3"></div>
    </div>
    <div class="row">
        <div class="col-sm">
        </div>
        <div class="col-sm">
            <form action="/login" method="post">
                <div class="mb-3">
                    <label for="InputID" class="form-label">ID</label>
                    <input name="user_id" type="text" class="form-control" id="InputID"
                           aria-describedby="emailHelp">
                    <div id="IDHelp" class="form-text">우리는 당신의 ID를 다른 사람과 절대 공유하지 않을 것입니다.</div>
                </div>
                <div class="mb-3">
                    <label for="InputPassword" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="InputPassword">
                </div>
                <button type="submit" class="btn btn-primary">LogIn</button>
            </form>
        </div>
        <div class="col-sm">
        </div>
    </div>

    <%@include file="./include/footer.jsp" %>
