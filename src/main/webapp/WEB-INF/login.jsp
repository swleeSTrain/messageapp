<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 8. 5.
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <div>
        <input name="user_id" type="text">
        <input name="password" type="password">
        <button>LOGIN</button>
    </div>
</form>
<form action="/signup" method="get">
    <button type="submit">Sign Up</button>
</form>
</body>
</html>
