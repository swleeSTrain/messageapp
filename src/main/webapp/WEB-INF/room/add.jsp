<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../include/header.jsp" %>

<div class="col-md-9">
<div class="container">
  <h1 class="mt-4">방 추가</h1>
  <form action="add" method="post">
    <div class="mb-3">
      <label for="room_name" class="form-label">방 이름</label>
      <input type="text" class="form-control" id="room_name" name="room_name" required>
    </div>
    <button type="submit" class="btn btn-primary">추가</button>
  </form>
</div>
</div>
<%@ include file="../include/footer.jsp" %>