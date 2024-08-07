<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp"%>

<h1>전체쪽지함</h1>
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