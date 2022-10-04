<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/nav.jsp" />

<div class="container mt-3">
<c:choose>
	<c:when test="${ses.grade == 99 }">
	<h2>Member List</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Email</th>
				<th>Nickname</th>
				<th>Reg At</th>
				<th>Last Login</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mvo" items="${list }">
				<tr>
					<td>${mvo.email }</td>
					<td><a href="/member/detail?email=${mvo.email }">${mvo.nickName }</a></td>
					<td>${mvo.regAt }</td>
					<td>${mvo.lastLogin }</td>
					<td>${mvo.grade }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
		<h2>권한이 필요한 페이지 입니다.</h2>
	</c:otherwise>
</c:choose>
</div>

<jsp:include page="../common/footer.jsp" />