<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<table border="1px">
  <thead>
  <tr>
    <td>Customer ID</td>
    <td>Name</td>
    <td>Email</td>
    <td>Address</td>
  </tr>
  </thead>
  <tbody>
    <c:forEach items="${listCustomer}" var="cu">
      <tr>
        <td>${cu.customerID}</td>
        <td><a href="/CustomerController/getByID?customerID=${cu.customerID}">${cu.customerName}</a></td>
        <td>${cu.customerEmail}</td>
        <td>${cu.customerAddress}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
