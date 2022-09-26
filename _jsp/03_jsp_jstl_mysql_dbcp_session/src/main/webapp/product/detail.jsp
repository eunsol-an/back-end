<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container mt-3">
  <h2>Emp Detail</h2>
</div>
<div class="container mt-3">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Pno : ${pvo.pno }</li>
    <li class="list-group-item">Pname : ${pvo.pname }</li>
    <li class="list-group-item">Price : ${pvo.price }</li>
    <li class="list-group-item">RegDate : ${pvo.regdate }</li>
    <li class="list-group-item">MadeBy : ${pvo.madeby }</li>
  </ul>
  <div>
    <a href="./list.pd" class="btn btn-primary">List</a>
    <c:if test="${ssevo ne null }">
	    <a href="./modify.pd?pno=${pvo.pno }" class="btn btn-outline-warning">Modify</a>
	    <a href="./remove.pd?pno=${pvo.pno }" class="btn btn-outline-danger">Remove</a>
    </c:if>
  </div>
</div>
<jsp:include page="../footer.jsp"/>