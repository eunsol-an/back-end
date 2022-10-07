<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/nav.jsp"/>

<div class="container mt-3">
  <h2>Board List <a href="/board/write" class="btn btn-primary btn-sm">write</a></h2>
  <p>The .table-hover class enables a hover state (grey background on mouse over) on table rows:</p>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>no</th>
        <th>title</th>
        <th>writer</th>
        <th>mod at</th>
        <th>read count</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="bvo" items="${list }">
      <tr>
        <td>${bvo.bno }</td>
        <td><a href="/board/${bvo.bno}">${bvo.title }</a></td>
        <td>${bvo.writer }</td>
        <td>${bvo.modAt }</td>
        <td>${bvo.readCount }</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<jsp:include page="../common/footer.jsp"/>