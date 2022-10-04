<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>

<div class="container mt-3">
  <h2>Product Modify</h2>
  <form action="/product/modify" method="post">
  <input type="hidden" name="pno" value="${pvo.pno }">
    <div class="mb-3 mt-3">
      <label for="category">Category:</label>
   	  <input type="text" class="form-control" id="category" placeholder="Enter category" name="category" value="${pvo.category }">
    </div>
    <div class="mb-3">
      <label for="pname">Product Name:</label>
      <input type="text" class="form-control" id="pname" placeholder="Enter pname" name="pname" value="${pvo.pname }">
    </div>
    <div class="mb-3">
      <label for="price">Price:</label>
      <input type="number" class="form-control" id="price" placeholder="Enter price" name="price" value=${pvo.price }>
    </div>
    <div class="mb-3">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${pvo.writer }" readonly>
    </div>
    <div class="mb-3">
      <label for="madeBy">Made By:</label>
      <input type="text" class="form-control" id="madeBy" placeholder="Enter madeBy" name="madeBy" value="${pvo.madeBy }">
    </div>
    <div class="mb-3">
      <label for="description">Description:</label>
      <textarea class="form-control" id="description" placeholder="Enter description" name="description">${pvo.description }</textarea>
    </div>
    <button type="submit" class="btn btn-primary">Modify</button>
  </form>
</div>

<jsp:include page="../common/footer.jsp"/>