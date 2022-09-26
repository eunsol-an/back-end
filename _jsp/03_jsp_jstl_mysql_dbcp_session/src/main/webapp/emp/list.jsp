<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
<div class="container mt-3">
  <h2>Emp List</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Empno</th>
        <th>Ename</th>
        <th>Hiredate</th>
        <th>Deptno</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="evo">
      <tr>
        <td>${evo.empno}</td>
        <td><a href="./detail.em?empno=${evo.empno }">${evo.ename}</a></td>
        <td>${evo.hiredate}</td>
        <td>${evo.deptno}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
<jsp:include page="../footer.jsp"/>