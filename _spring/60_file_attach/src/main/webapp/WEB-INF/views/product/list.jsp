<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<c:set var="ses" value="${sesDto.mvo }" />
<div class="container mt-5">
	<h2>Product List 
		<c:if test="${ses.email ne null && ses.email ne '' }">
			<a href="/product/write" class="btn btn-primary ms-3">write</a>
		</c:if>
	</h2>
	<table class="table table-hover mt-5">
		<thead>
			<tr>
				<th>No</th>
				<th>Category</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Writer</th>
				<th>Mod At</th>
				<th>Read Count</th>
				<th>Attach</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pvo" items="${list }">
				<tr>
					<td>${pvo.pno }</td>
					<td>${pvo.category }</td>
					<td><a href="/product/detail?pno=${pvo.pno}&pageNo=${pgn.pgvo.pageNo }&qty=${pgn.pgvo.qty }&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw }">${pvo.pname }(${pvo.cmtQty })</a></td>
					<td>${pvo.price }</td>
					<td>${pvo.writer }</td>
					<td>${pvo.modAt }</td>
					<td>${pvo.readCount }</td>
					<td>
						<c:if test="${pvo.fileCount > 0 }">
						<i class="material-icons">attachment</i>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pagination justify-content-center">
		<c:if test="${pgn.prev }">
	    	<li class="page-item"><a class="page-link" href="/product/list?pageNo=${pgn.startPage-1 }&qty=${pgn.pgvo.qty }&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw }">Prev</a></li>
	    </c:if>
    	<c:forEach begin="${pgn.startPage }" end="${pgn.endPage }" var="i">
		    <li class="page-item ${pgn.pgvo.pageNo == i ? 'active' : '' }"><a class="page-link" href="/product/list?pageNo=${i }&qty=${pgn.pgvo.qty}&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw }">${i }</a></li>
	    </c:forEach>
	    <c:if test="${pgn.next }">
	    	<li class="page-item"><a class="page-link" href="/product/list?pageNo=${pgn.endPage+1 }&qty=${pgn.pgvo.qty }&type=${pgn.pgvo.type}&kw=${pgn.pgvo.kw }">Next</a></li>
	    </c:if>
  	</ul>
  	<form class="d-flex col-sm-12 col-md-6 mx-auto" action="/product/list" method="get">
  		<input type="hidden" name="pageNo" value="1">
  		<input type="hidden" name="qty" value="${pgn.pgvo.qty }">
  		<div class="input-group">
  		<c:set value="${pgn.pgvo.type }" var="typed" />
		<select class="form-select" name="type">
		  <option ${typed eq null ? 'selected':'' }>선택</option>
		  <option value="twc" ${typed eq 'twc' ? 'selected':'' }>All</option>
		  <option value="t" ${typed eq 't' ? 'selected':'' }>Title</option>
		  <option value="w" ${typed eq 'w' ? 'selected':'' }>Writer</option>
		  <option value="c" ${typed eq 'c' ? 'selected':'' }>Content</option>
		  <option value="tw" ${typed eq 'tw' ? 'selected':'' }>Title or Writer</option>
		  <option value="tc" ${typed eq 'tc' ? 'selected':'' }>Title or Content</option>
		  <option value="wc" ${typed eq 'wc' ? 'selected':'' }>Writer or Content</option>
		</select>
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="kw" value="${pgn.pgvo.kw }">
        <button class="btn btn-outline-success" type="submit">Search 
        <span class="badge bg-danger">${pgn.totalCount }</span></button>
        </div>
    </form>
</div>

<script>
let msg_del = '<c:out value="${msg_del}"/>';
if (parseInt(msg_del)) {
	alert('상품 삭제가 완료되었습니다');
}
</script>
<jsp:include page="../common/footer.jsp" />