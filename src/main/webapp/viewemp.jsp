<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<table class="striped">
<thead>
          <tr>
              <th>Employee ID</th>
              <th>Employee Name</th>
              <th>age</th>
          </tr>
        </thead>
  
    <tr>
      <td>${emp.empId}</td>
      <td>${emp.empName}</td>
      <td>${emp.age}</td>
    </tr>

</table>
</div>

</body>
</html>