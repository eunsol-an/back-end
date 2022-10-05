<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>

<div class="container mt-3">
  <h2>Member Modify</h2>
  <form action="/member/modify" method="post">
    <div class="mb-3 mt-3">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value="${mvo.email }" readonly>
    </div>
    <div class="mb-3">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" value="${mvo.pwd }">
    </div>
    <div class="mb-3">
      <label for="nickName">NickName:</label>
      <input type="text" class="form-control" id="nickName" placeholder="Enter nickname" name="nickName" value="${mvo.nickName }">
    </div>
    <c:if test="${ses.grade == 99 }">
    <div class="mb-3">
      <label for="grade">Grade:</label>
      <input type="number" class="form-control" id="grade" placeholder="Enter grade" name="grade" value="${mvo.grade }">
    </div>
    </c:if>
    <button type="submit" class="btn btn-primary">Modify</button>
  </form>
</div>

<jsp:include page="../common/footer.jsp"/>