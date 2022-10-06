<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-3">
	<div class="d-flex my-5">
		<h2>Product List</h2>
		<c:if test="${ses.email ne null && ses.email ne '' }">
			<a href="/product/write" class="btn btn-primary ms-3">write</a>
		</c:if>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>No</th>
				<th>Category</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Writer</th>
				<th>Mod At</th>
				<th>Read Count</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pvo" items="${list }">
				<tr>
					<td>${pvo.pno }</td>
					<td>${pvo.category }</td>
					<td><a href="/product/detail?pno=${pvo.pno}">${pvo.pname }(${pvo.cmtQty })</a></td>
					<td>${pvo.price }</td>
					<td>${pvo.writer }</td>
					<td>${pvo.modAt }</td>
					<td>${pvo.readCount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
let msg_del = '<c:out value="${msg_del}"/>';
if (parseInt(msg_del)) {
	alert('상품 삭제가 완료되었습니다');
}
</script>
<jsp:include page="../common/footer.jsp" />