<%@ page import="com.chernykh.sprint11.dao.AddressBook" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.chernykh.sprint11.utils.RecordParser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Records from Address Book</title>
</head>
<body>
<%@include file="header.html" %>
<br><br>

<form action="/records/list" method="post">
    Sort by: <input type="submit" value="ascending" name="ascBtn"/>
    <input type="submit" value="descending" name="descBtn"/>
</form>
<table border="1">
    <tr>
        <th>No.</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Address</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        AddressBook addressBook = (AddressBook) request.getAttribute("records");
        Iterator addressBookIterator = addressBook.iterator();
        int i = 1;
        while (addressBookIterator.hasNext()) {
            String record = addressBookIterator.next().toString();
            String firstName = RecordParser.getFirstName(record);
            String lastName = RecordParser.getLastName(record);
            String address = RecordParser.getAddress(record);
    %>
    <tr>
        <td>
            <%=i++%>
        </td>
        <td><%=firstName%>
        </td>
        <td><%=lastName%>
        </td>
        <td><%=address%>
        </td>
        <td>
            <a href="/records/read?first-name=<%=firstName%>&last-name=<%=lastName%>">Read</a>
        </td>
        <td>
            <a href="/records/update?first-name=<%=firstName%>&last-name=<%=lastName%>">Update</a>
        </td>
        <td>
            <a href="/records/delete?first-name=<%=firstName%>&last-name=<%=lastName%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
