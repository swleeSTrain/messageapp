<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp"%>z

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
