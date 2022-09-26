<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<h1>index.jsp</h1>
<script>
let msg_login = '<c:out value="${msg_login}"/>'; // '0'
let msg_logout = '<c:out value="${msg_logout}"/>'; // '1'
if(msg_login === '0'){
	alert('로그인 실패!');
}
if(msg_logout === '1'){
	  alert('로그아웃 되었습니다');
	}
</script>
<jsp:include page="footer.jsp"/>