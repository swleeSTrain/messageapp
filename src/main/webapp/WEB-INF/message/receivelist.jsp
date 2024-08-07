<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        h1{
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

<h1>받은쪽지함</h1>
<ul>
    <c:forEach var="receive_message" items="${receive_messages}">
        <li>
                ${receive_message}
        </li>
    </c:forEach>
</ul>
</div>
</div>
<%@include file="../include/footer.jsp"%>
