<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Record not found</title>
</head>
<body>
<h1>Person with name '<%=request.getParameter("first-name") + " " + request.getParameter("last-name")%>' not found in
    Address Book!</h1>
</body>
</html>
