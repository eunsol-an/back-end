<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <c:set var="ssevo" value="${ses }" scope="session"/>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <c:if test="${ssevo eq null }">
	        <li class="nav-item">
	          <a class="nav-link" href="/emp/register.em">Emp Register</a>
	        </li>
        </c:if>
        <c:if test="${ssevo.job eq 'MGR' }"> <!-- job이 MGR인 회원만 열람 가능 -->
        <li class="nav-item">
          <a class="nav-link" href="/emp/list.em">Emp List</a>
        </li>
        </c:if>
        <%-- <c:if test="${ssevo ne null }">
	        <li class="nav-item">
	          <a class="nav-link" href="/product/register.pd">Product Register</a>
	        </li>
        </c:if> --%>
        <li class="nav-item">
          <a class="nav-link" href="/product/list.pd">Product List</a>
        </li>
        <c:if test="${ssevo eq null }">
	        <li class="nav-item">
	          <a class="nav-link" href="/emp/login.em">Login</a>
	        </li>
        </c:if>
        <c:if test="${ssevo ne null }"> <!-- 로그인 된 회원에게 계정 정보 출력 -->
          <li class="nav-item">
            <a class="nav-link" href="/emp/detail.em?empno=${ssevo.empno }">${ssevo.ename }(${ssevo.job })</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/emp/logout.em">Logout</a>
          </li>
        </c:if>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>