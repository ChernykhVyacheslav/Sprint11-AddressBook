<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Record from Address Book</title>
</head>
<body>
<%@include file="header.html" %>
<br><br>

<%
    String firstName = request.getAttribute("firstName").toString();
    String lastName = request.getAttribute("lastName").toString();
    String address = request.getAttribute("address").toString();
%>
<table>
    <tr>
        <td>First name: </td>
        <td><b><%=firstName%></b></td>
    </tr>
    <tr>
        <td>Last name: </td>
        <td><b><%=lastName%></b></td>
    </tr>
    <tr>
        <td>Address: </td>
        <td><b><%=address%></b></td>
    </tr>
</table>
</body>
</html>
