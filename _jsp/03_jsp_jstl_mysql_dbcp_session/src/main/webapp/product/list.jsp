<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container mt-3">
  <div class="d-flex">
	  <h2 class="me-3">Product List</h2>
	  <c:if test="${ssevo ne null }">
	   <a class="btn btn-primary" href="/product/register.pd">Register</a>
	  </c:if>
  </div>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Pno</th>
        <th>Pname</th>
        <th>Price</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="pvo">
      <tr>
        <td>${pvo.pno}</td>
        <td><a href="./detail.pd?pno=${pvo.pno}">${pvo.pname}</a></td>
        <td>${pvo.price}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<jsp:include page="../footer.jsp"/>