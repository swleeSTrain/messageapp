<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/menuui.jsp"%>

<div class="col-md-9">
<div class="container">
    <h1 class="mt-4">학생 방 배정</h1>
    <form action="/room/assign" method="post">
        <input type="hidden" name="room_no" id="room_no" value="${room_no}">
        <div class="mb-3">
            <label for="student_id" class="form-label">학생 선택</label>
            <select class="form-control" id="student_id" name="student_id" required>
                <c:forEach var="student" items="${students}">
                    <option value="${student.user_id}">${student.user_name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">배정</button>
    </form>
</div>
</div>
</div>
<%@ include file="../include/footer.jsp" %>
