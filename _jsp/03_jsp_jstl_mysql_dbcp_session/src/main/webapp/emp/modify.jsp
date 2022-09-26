<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<jsp:include page="../nav.jsp"/>
  <div class="container mt-3">
    <h2>Modify</h2>
    <form action="./update.em" method="post">
      <div class="mb-3 mt-3">
        <label for="empno">Empno:</label>
        <input type="text" class="form-control" id="empno" name="empno" 
        value="${evo.empno }" readonly>
      </div>
      <div class="mb-3 mt-3">
        <label for="ename">Ename:</label>
        <input type="text" class="form-control" id="ename" 
        value="${evo.ename }" name="ename" readonly>
      </div>
      <div class="mb-3 mt-3">
        <label for="job">Job:</label>
        <input type="text" class="form-control" id="job" 
        value="${evo.job }" name="job">
      </div>
      <div class="mb-3 mt-3">
        <label for="mgr">Mgr:</label>
        <input type="text" class="form-control" id="mgr" 
        value="${evo.mgr }" name="mgr">
      </div>
      <div class="mb-3 mt-3">
        <label for="hiredate">Hiredate:</label>
        <input type="date" class="form-control" id="hiredate" 
        value="${evo.hiredate }" name="hiredate" readonly>
      </div>
      <div class="mb-3 mt-3">
        <label for="sal">Salary:</label>
        <input type="text" class="form-control" id="sal" 
        value="${evo.sal }" name="sal">
      </div>
      <div class="mb-3 mt-3">
        <label for="comm">Commission:</label>
        <input type="text" class="form-control" id="comm" 
        value="${evo.comm }" name="comm">
      </div>
      <div class="mb-3 mt-3">
        <label for="deptno">Deptno:</label>
        <input type="text" class="form-control" id="deptno" 
        value="${evo.deptno }"name="deptno">
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
<jsp:include page="../footer.jsp"/>