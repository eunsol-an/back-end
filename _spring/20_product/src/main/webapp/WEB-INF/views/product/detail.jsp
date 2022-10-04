<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-sm-6">
			<h5>${pvo.category }</h5>
			<h2>${pvo.pname }(${pvo.cmtQty })</h2>
			<p>작성자 : ${pvo.writer } | 조회수 : ${pvo.readCount } | ${pvo.modAt }</p>
			<p>Price : ${pvo.price }</p>
			<p>Made By : ${pvo.madeBy }</p>
			<p>Description : ${pvo.description }</p>
			<div class="d-flex">
				<a href="/product/modify?pno=${pvo.pno }" class="btn btn-primary me-3">Product Modify</a>
				<a id="productRemove" class="btn btn-outline-danger">Product Remove</a>
				<form action="" id="productRmForm" method="post"
					style="display: none;">
					<input type="hidden" value="${pvo.pno }" name="pno">
				</form>
			</div>
		</div>
	</div>
</div>

<script>
let msg_mod = '<c:out value="${msg_mod}"/>';
if (parseInt(msg_mod)) {
	alert('상품 수정이 완료되었습니다');
}
</script>
<script src="/resources/js/product.detail.js"></script>
<jsp:include page="../common/footer.jsp" />