<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Customer ID</th>
        <th>${customer.customerID}</th>
    </tr>
    <tr>
        <th>Name</th>
        <th>${customer.customerName}</th>
    </tr>
    <tr>
        <th>Email</th>
        <th>${customer.customerEmail}</th>
    </tr>
    <tr>
        <th>Address</th>
        <th>${customer.customerAddress}</th>
    </tr>
</table>
</body>
</html>
