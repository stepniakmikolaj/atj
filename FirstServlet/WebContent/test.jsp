<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kalkulator</title>
</head>
<body>
	<%--<form action="calculate.jsp">--%>
	<form action="MyServlet">
		<h1>Kalkulator</h1>
		<input type="number" min="0" max="99" name="value1"
			required="required"> <select name="action">
			<option value="add" selected>dodawanie</option>
			<option value="sub">odejmowanie</option>
			<option value="mul">mnożenie</option>
			<option value="div">dzielenie</option>
			<option value="mod">modulo</option>
		</select> <input type="number" min="0" max="99" name="value2"
			required="required"> <input type="submit" value="Oblicz">
	</form>
</body>
</html>