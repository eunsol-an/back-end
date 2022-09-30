<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />

<!-- Header -->
<header class="ex-header">
	<div class="container">
		<div class="row">
			<div class="col-xl-10 offset-xl-1">
				<h1 class="text-center">Board Register</h1>
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
<div class="ex-form-1 pt-5 pb-5">
	<div class="container">
		<div class="row">
			<div class="col-xl-6 offset-xl-3">
				<div class="text-box mt-5 mb-5">

					<!-- Register Form -->
					<form action="/brd/insert" method="post" enctype="multipart/form-data">
						<div class="mb-4 form-floating">
							<input type="text" class="form-control" id="floatingInput"
								placeholder="title" name="title" required>
								<label for="floatingInput">Title</label>
						</div>
						<div class="mb-4 form-floating">
							<input type="text" class="form-control" id="floatingInput2"
								placeholder="price" name="price" required>
								<label for="floatingInput2">Price</label>
						</div>
						<div class="mb-4 form-floating">
							<input type="text" class="form-control" id="floatingInput3"
								placeholder="made_by" name="made_by" required>
								<label for="floatingInput3">Made By</label>
						</div>
						<div class="mb-4 form-floating">
							<input type="text" class="form-control" id="floatingInput4"
								placeholder="writer" name="writer" value="${ses.nick_name }" readonly>
								<label for="floatingInput4">Writer</label>
						</div>
						<div class="mb-4 form-floating">
							<input type="text" class="form-control" id="floatingInput5"
								placeholder="category" name="category">
								<label for="floatingInput5">Category</label>
						</div>
						<div class="mb-4 form-floating">
							<textarea class="form-control" id="floatingInput6"
								placeholder="description" name="description"></textarea>
								<label for="floatingInput6">Description</label>
						</div>
						<div class="mb-4 form-floating">
              <input type="file" class="form-control" id="file" name="imageFile"
              accept="image/png, image/jpeg, image/jpg, image/gif">
                <label for="file">Image File</label>
            </div>
						<button type="submit" class="form-control-submit-button">Register</button>
					</form>
					<!-- end of register form -->

				</div>
				<!-- end of text-box -->
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