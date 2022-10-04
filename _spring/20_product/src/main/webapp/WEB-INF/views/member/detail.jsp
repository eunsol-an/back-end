<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-3">
	<h2>Member Detail</h2>
	<div class="card mt-4">
		<div class="card-body p-5">
			<h4 class="card-title" id="emVal">${mvo.email }</h4>
			<div class="card-text">
				<ul class="list-group list-group-flush my-4">
					<li class="list-group-item">Nickname : ${mvo.nickName }</li>
					<li class="list-group-item">Reg At : ${mvo.regAt }</li>
					<li class="list-group-item">Last Login : ${mvo.lastLogin }</li>
					<li class="list-group-item">Grade : ${mvo.grade }</li>
				</ul>
				<div class="d-flex">
				<a href="/member/modify?email=${mvo.email }" class="btn btn-primary me-3">Member
					Modify</a>
				<a id="memberRemove" class="btn btn-outline-danger">Member
					Remove</a>
				<form action="" id="memberRmForm" method="post" style="display:none;">
					<input type="hidden" id="em" value="" name="email">
				</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="/resources/js/member.detail.js"></script>
<jsp:include page="../common/footer.jsp" />