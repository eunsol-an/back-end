<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-5">
	<div class="row justify-content-center">
		<div class="col-sm-6 mb-4">
			<h5 id="pnoVal">${pvo.pno }</h5>
			<h5>${pvo.category }</h5>
			<h2>${pvo.pname }(${pvo.cmtQty })</h2>
			<p>작성자 : ${pvo.writer } | 조회수 : ${pvo.readCount } | ${pvo.modAt }</p>
			<p>Price : ${pvo.price }</p>
			<p>Made By : ${pvo.madeBy }</p>
			<p>Description : ${pvo.description }</p>
			<div class="d-flex">
				<a href="/product/modify?pno=${pvo.pno }"
					class="btn btn-primary me-3">Product Modify</a> <a
					id="productRemove" class="btn btn-outline-danger">Product
					Remove</a>
				<form action="" id="productRmForm" method="post"
					style="display: none;">
					<input type="hidden" value="${pvo.pno }" name="pno">
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Button to Open the Modal -->
<button type="button" class="btn btn-primary" style="display:none;" id="modalBtn"
data-bs-toggle="modal" data-bs-target="#myModal">
  Open modal
</button>


<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-success modSbmBtn" data-bs-dismiss="modal" data-cno="">Modify</button>
      </div>

    </div>
  </div>
</div>

<div class="container mt-3">
	<div class="row justify-content-center">
		<div class="col-sm-6">
			<h2>Comment</h2>
			<c:if test="${ses.email ne null and ses.email ne '' }">
				<div class="input-group mb-3">
					<span class="input-group-text" id="cmtWriter">${ses.email }</span> <input
						type="text" class="form-control" placeholder="Add comment"
						id="cmtText">
					<button type="button" class="btn btn-primary" id="cmtSbmBtn">ADD</button>
				</div>
			</c:if>
			<table class="table">
				<thead>
					<tr>
						<th>Writer</th>
						<th>Content</th>
						<th>Mod At</th>
						<th>Mod</th>
						<th>Del</th>
					</tr>
				</thead>
				<tbody id="cmtZone"></tbody>
			</table>
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
<script src="/resources/js/product.comment.js"></script>
<jsp:include page="../common/footer.jsp" />