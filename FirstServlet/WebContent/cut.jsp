<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>link</title>
   </head>
   <body>
   <%@ page language="java" %>
   <%@ page import="java.util.*" %>
   <%
   Map<String, String> mapa = new LinkedHashMap<String, String>();
   String linkLong = request.getParameter("link");
   String myLink = "https://miki/";
   int paramSelect = Integer.parseInt(request.getParameter("action"));
   String chars = "qwertyuiopasdfghjklzxcvbnm";
   int length = chars.length();
   java.util.Random r = new java.util.Random();
   
   for (int i = 0; i < paramSelect; i++) {
	   myLink += chars.charAt(r.nextInt(length));
   }
   
   mapa.put(myLink, linkLong);
   
   out.println("your link = " + linkLong + "\n");
   %>
   <br>
   <% 
   out.println("cut link = " + myLink); 
   %>
   <br>
   <%
   for (Map.Entry<String, String> entry : mapa.entrySet()) {
	  String key = entry.getKey();
	  String value = entry.getValue();
	  out.println("KEY: " + key + " : " + "VALUE: " + value);
   }
   %>
   </body>
 </html>