<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>

<!-- Header -->
<header class="ex-header">
  <div class="container">
    <div class="row">
      <div class="col-xl-10 offset-xl-1">
        <h1>${pvo.pname }</h1>
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
          src="../resources/dist/images/article-details-large.jpg"
          alt="alternative">
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
              <strong>pno</strong> ${pvo.pno }
            </div></li>
          <li class="d-flex"><i class="fas fa-square"></i>
            <div class="flex-grow-1">
              <strong>price</strong> ${pvo.price }
            </div></li>
          <li class="d-flex"><i class="fas fa-square"></i>
            <div class="flex-grow-1">
              <strong>made by</strong> ${pvo.madeby }
            </div></li>
          <li class="d-flex"><i class="fas fa-square"></i>
            <div class="flex-grow-1">
              <strong>reg date</strong> ${pvo.regdate }
            </div></li>
        </ul>
        <a class="btn-solid-reg mb-5" href="/pd/list">List</a>
          <a class="btn-solid-reg mb-5" href="/pd/modify?pno=${pvo.pno }">Modify</a>
          <a class="btn-solid-reg mb-5" href="/pd/remove?pno=${pvo.pno }">Remove</a>
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
        <h2 class="h2-heading">Product Comment</h2>
        <c:if test="${ses ne null }">
          <div class="input-group mb-3">
            <span class="input-group-text" id="replier">${ses.email }</span>
            <input type="text" class="form-control" id="rplText" placeholder="Add Comment">
            <button class="btn btn-success" type="button" id="rplAddBtn">ADD</button> 
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
const pnoVal = '<c:out value="${pvo.pno}"/>';
</script>
<script src="/resources/js/product.detail.js"></script>
<script>
printRepliesList(pnoVal);
</script>

<jsp:include page="../footer.jsp"/>