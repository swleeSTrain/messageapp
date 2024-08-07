<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        h1 {
            font-family: HY견명조;
            font-weight: normal;
        }
        div {
            font-family: HY견명조;
            font-weight: normal;
        }
    </style>
</head>
<body>
<div class="container text-center">
    <div class="row">
        <div class="col-6 col-md-3"></div>
        <div class="col-6 col-md-6"><h1>회원가입 페이지</h1></div>
        <div class="col-6 col-md-3"></div>
    </div>
    <div class="row">
        <div class="col-sm">
        </div>
        <div class="col-sm">
            <form action="/signup" method="post">
                <div class="mb-3">
                    <label for="InputID" class="form-label">ID</label>
                    <input name="user_id" type="text" class="form-control" id="InputID" aria-describedby="idHelp" required>
                </div>
                <div class="mb-3">
                    <label for="InputName" class="form-label">이름</label>
                    <input name="user_name" type="text" class="form-control" id="InputName" required>
                </div>
                <div class="mb-3">
                    <label for="InputPassword" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="InputPassword" required>
                </div>
                <div class="mb-3">
                    <label for="InputRole" class="form-label">역할</label>
                    <select name="role" id="InputRole" class="form-select" required>
                        <option value="STUDENT">학생</option>
                        <option value="ADMIN">관리자</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">가입하기</button>
            </form>
        </div>
        <div class="col-sm">
        </div>
    </div>

<%@ include file="./include/footer.jsp" %>