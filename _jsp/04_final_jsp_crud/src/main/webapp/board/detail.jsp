<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<!-- Header -->
<header class="ex-header">
	<div class="container">
		<div class="row">
			<div class="col-xl-10 offset-xl-1">
				<h1>${bvo.title }</h1>
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</header>
<!-- end of ex-header -->
<!-- end of header -->


<!-- Basic -->
<div class="ex-basic-1 pt-5 pb-5">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<img class="img-fluid mt-5 mb-3"
					src="../resources/dist/images/article-details-large.jpg" alt="alternative">
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</div>
<!-- end of ex-basic-1 -->
<!-- end of basic -->

<!-- Basic -->
<div class="ex-basic-1 pt-3 pb-5">
	<div class="container">
		<div class="row">
			<div class="col-xl-10 offset-xl-1">
				<ul class="list-unstyled li-space-lg mb-5">
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>bno</strong> ${bvo.bno }</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>price</strong> ${bvo.price }</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>made by</strong> ${bvo.made_by }</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>reg at</strong> ${bvo.reg_at }</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>writer</strong> ${bvo.writer }</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>category</strong> ${bvo.category }</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>mod at</strong> ${bvo.mod_at }</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>read count</strong> ${bvo.read_count }</div></li>
				</ul>
				
				<div class="text-box mb-5">
          <h3>Description</h3>
          <p>${bvo.description }</p>
        </div>

				<a class="btn-solid-reg mb-5" href="/brd/list">List</a>
				<c:if test="${ses.nick_name eq bvo.writer }">
					<a class="btn-solid-reg mb-5" href="/brd/modify?bno=${bvo.bno }">Modify</a>
					<a class="btn-solid-reg mb-5" href="/brd/remove?bno=${bvo.bno }">Remove</a>
				</c:if>
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</div>
<!-- end of ex-basic-1 -->
<!-- end of basic -->

<jsp:include page="../footer.jsp" />