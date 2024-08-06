<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 8. 5.
  Time: 오후 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul class="list-group">
    <c:forEach var="message" items="${messages}" >
        <li class="list-group-item" style="width: 500px; height: 100px; align-self: center;  " >
          작성자 : ${message.sender_id} 시간 : ${message.timestamp} 내용 : ${message.message_content}
        </li>
    </c:forEach>
</ul>
<form action="/message/send" method="get">
    <button type="submit">새 쪽지 보내기</button>
</form>
</body>
</html>
