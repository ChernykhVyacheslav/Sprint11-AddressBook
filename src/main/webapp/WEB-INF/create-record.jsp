<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Create new Record in Address Book</title>
</head>
<body>
<%@include file="header.html" %>
<br><br>

<div style="color: #FF0000;"><%=(request.getAttribute("errorMessage") == null) ? "" : request.getAttribute("errorMessage")%></div>

<form action="/records/create" method="post">
    <table>
        <tr>
            <td>
                <label for="firstName">First name: </label>
            </td>
            <td>
                <input type="text" id="firstName" name="firstName" required
                       value=<%=(request.getAttribute("firstName") == null) ? "" : request.getAttribute("firstName")%>>
            </td>
        </tr>
        <tr>
            <td>
                <label for="lastName">Last name: </label>
            </td>
            <td>
                <input type="text" id="lastName" name="lastName" required
                       value=<%=(request.getAttribute("lastName") == null) ? "" : request.getAttribute("lastName")%>>
            </td>
        </tr>
        <tr>
            <td>
                <label for="address">Address: </label>
            </td>
            <td>
                <textarea id="address" name="address" required><%=(request.getAttribute("address") == null) ? "" : request.getAttribute("address")%></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>

</body>
</html>