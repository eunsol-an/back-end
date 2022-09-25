<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Register</title>
</head>
<body>
	<form action="./insert.pd" method="post">
		<table border="1">
			<tr>
				<th>Name :</th>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<th>Price :</th>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<th>Made By :</th>
				<td><input type="text" name="madeBy"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">상품등록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>