<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>Wynik</title>
   </head>
   <body>
   <%@ page language="java" %>
   <%
   double result = 0;
   String paramSelect = request.getParameter("action");
	double valueOne = Double.parseDouble(request.getParameter("value1"));
	double valueTwo = Double.parseDouble(request.getParameter("value2"));
	if (paramSelect.equals("add")) {
		result = valueOne + valueTwo;
	} else if (paramSelect.equals("sub")) {
		result = valueOne - valueTwo;
	} else if (paramSelect.equals("mul")) {
		result = valueOne * valueTwo;
	} else if (paramSelect.equals("div")){
	    result = valueOne / valueTwo;
	} else {
		result = valueOne % valueTwo;
	}
   out.println("jsp result = " + result);
   %>
   </body>
 </html>