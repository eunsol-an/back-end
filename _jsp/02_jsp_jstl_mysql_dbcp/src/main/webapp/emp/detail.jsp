<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container mt-3">
  <h2>Emp Detail</h2>
</div>
<div class="container mt-3">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Empno : ${evo.empno }</li>
    <li class="list-group-item">Ename : ${evo.ename }</li>
    <li class="list-group-item">Job : ${evo.job }</li>
    <li class="list-group-item">MGR : ${evo.mgr }</li>
    <li class="list-group-item">Hiredate : ${evo.hiredate }</li>
    <li class="list-group-item">Salary : ${evo.sal }</li>
    <li class="list-group-item">Commission : ${evo.comm }</li>
    <li class="list-group-item">Deptno : ${evo.deptno }</li>
  </ul>
  <div>
    <a href="./list.em" class="btn btn-primary">List</a>
    <a href="./modify.em?empno=${evo.empno }" class="btn btn-outline-warning">Modify</a>
    <a href="./remove.em?empno=${evo.empno }" class="btn btn-outline-danger">Remove</a>
  </div>
</div>
<jsp:include page="../footer.jsp"/>