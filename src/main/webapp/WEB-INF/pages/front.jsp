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

<form action="helloworld.do" method ="post">

Message <input type = "text" name="message"/>
City <input type = "text" name="city"/>
Latitude <input type = "text" name="city_latitude"/>
Longitude <input type = "text" name="city_longitude"/>
Temperature <input type = "text" name="temperature"/>

 <input type="submit" value="Send"/>

</form>

 <footer>
${message}

${user}

${timestamp}

</footer>

</body>
</html>