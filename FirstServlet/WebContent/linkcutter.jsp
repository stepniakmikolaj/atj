<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
     <title>link cutter</title>
   </head>
   <body>
   <%--<form action="cut.jsp">--%>
   <form action="LinkCutter">
   <h1>LINK CUTTER</h1>
		<input type="text" name="link" required="required">
		<select name="action">
			<option value="3" selected>3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
		</select>
		<input type="submit" value="CUT">
	</form>
   </body>
 </html>