<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 class="center-align">All Employees</h3><br><br><br>
<div class="container">
<table class="striped">
<thead>
 <tr>
              <th>Employee ID</th>
              <th>Employee Name</th>
              <th>age</th>
           </tr>
           </thead>
  <c:forEach items="${empList}" var="emp">
    <tr>
      <td>${emp.empId}</td>
      <td>${emp.empName}</td>
      <td>${emp.age}</td>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>