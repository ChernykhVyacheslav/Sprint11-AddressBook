<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Update existing Record in Address Book</title>
</head>
<body>
<%@include file="header.html" %>
<br><br>

<%
    request.getSession().setAttribute("firstName", request.getAttribute("firstName"));
    request.getSession().setAttribute("lastName", request.getAttribute("lastName"));
%>

<form action="/records/update" method="post">
    <table>
        <tr>
            <td>
                <label for="firstName">First name: </label>
            </td>
            <td>
                <input type="text" id="firstName" name="firstName" disabled
                       value=<%=request.getAttribute("firstName")%>>
            </td>
        </tr>
        <tr>
            <td>
                <label for="lastName">Last name: </label>
            </td>
            <td>
                <input type="text" id="lastName" name="lastName" disabled
                       value=<%=request.getAttribute("lastName")%>>
            </td>
        </tr>
        <tr>
            <td>
                <label for="address">Address: </label>
            </td>
            <td>
                <textarea id="address" name="address" required><%=request.getAttribute("address")%></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Update">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>

</body>
</html>