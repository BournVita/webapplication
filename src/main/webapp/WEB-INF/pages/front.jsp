<%@page import="webapp.App"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello world jsp</title>
</head>
<%-- <%
java.util.Date date = new java.util.Date();


%>
<div>Current date is <%=date%> </div> --%>

<body>
HELLO WORLD !!!

<form action="/helloworld.do" method ="post">

Enter message <input type = "text" name="message"/> <input type="submit" value="Send"/>

</form>

${message}

${message}

<% 

App a1 = (App)session.getAttribute("userdata");
out.println(a1);

%>



</body>
</html>