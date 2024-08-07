<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/header.jsp"%>
<h1>보낸쪽지함</h1>
<ul>
    <c:forEach var="send_message" items="${send_messages}">
        <li>
                ${send_message}
        </li>
    </c:forEach>
</ul>
</div>
</div>
<%@include file="../include/footer.jsp"%>
