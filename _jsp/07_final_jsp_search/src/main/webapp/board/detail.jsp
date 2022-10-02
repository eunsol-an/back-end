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
		   <c:if test="${bvo.image_file ne null  && bvo.image_file ne ''}">
	        <img class="img-fluid mt-5 mb-3" id="imgFile" src="/_fileUpload/${bvo.image_file }" alt="alternative"><br>
	        <button type="button" class="btn btn-outline-danger mb-5" id="fileDelBtn">File DEL</button>
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

<!-- Basic -->
<div class="ex-basic-1 pt-3 pb-5">
	<div class="container">
		<div class="row">
			<div class="col-xl-10 offset-xl-1">
				<ul class="list-unstyled li-space-lg mb-5">
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>bno</strong> ${bvo.bno }
						</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>price</strong> ${bvo.price }
						</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>made by</strong> ${bvo.made_by }
						</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>reg at</strong> ${bvo.reg_at }
						</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>writer</strong> ${bvo.writer }
						</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>category</strong> ${bvo.category }
						</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>mod at</strong> ${bvo.mod_at }
						</div></li>
					<li class="d-flex"><i class="fas fa-square"></i>
						<div class="flex-grow-1">
							<strong>read count</strong> ${bvo.read_count }
						</div></li>
				</ul>

				<div class="text-box mb-5">
					<h3>Description</h3>
					<p>${bvo.description }</p>
				</div>

				<a class="btn-solid-reg mb-5" href="/brd/list">List</a>
				<c:if test="${ses.nick_name eq bvo.writer }">
					<a class="btn-solid-reg mb-5" href="/brd/modify?bno=${bvo.bno }">Modify</a>
					<a class="btn-solid-reg mb-5" href="/brd/remove?bno=${bvo.bno }&image_file=${bvo.image_file}">Remove</a>
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

<!-- Questions -->
<div class="accordion-1">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="h2-heading">Board Comment</h2>
				<c:if test="${ses ne null }">
					<div class="input-group mb-3">
					  <span class="input-group-text" id="cmtWriter">${ses.email }</span>
				    <input type="text" class="form-control" id="cmtText" placeholder="Add Comment">
				    <button class="btn btn-success" type="button" id="cmtAddBtn">ADD</button> 
				  </div>
			  </c:if>
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="accordion" id="accordionExample">

					<!-- Accordion Item -->
					<div class="accordion-item">
						<h2 class="accordion-header" id="headingOne">
							<button class="accordion-button" type="button"
								data-bs-toggle="collapse" data-bs-target="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne">cno, bno, writer</button>
						</h2>
						<div id="collapseOne" class="accordion-collapse collapse show"
							aria-labelledby="headingOne" data-bs-parent="#accordionExample">
							<div class="accordion-body">content, mod_at</div>
						</div>
					</div>
					<!-- end of accordion-item -->
					
				</div>
				<!-- end of accordion -->
			</div>
			<!-- end of col -->
		</div>
		<!-- end of row -->
	</div>
	<!-- end of container -->
</div>
<!-- end of accordion-1 -->
<!-- end of questions -->
<script>
const bnoVal = '<c:out value="${bvo.bno}"/>';
</script>
<script src="/resources/js/board.detail.js"></script>
<script>
printCommentList(bnoVal);
</script>
<jsp:include page="../footer.jsp" />