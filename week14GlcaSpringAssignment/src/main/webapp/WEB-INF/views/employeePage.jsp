<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    text-align: center;
    background-color: aqua;
}
table {
    margin: auto;
}
a{
text-align: center;
font-size: large;
font-weight: bold; 
cursor: pointer;
}
</style>
</head>
<body>

<a href="addEmplyee"> Add Record </a>
<table border="2">
<tr>

<th>Employee Name</th>
<th>Employee Address</th>
<th>Employee Phone</th>
<th>Employee Salary</th>
<th>Action 1</th>
<th>Action 2</th>
</tr>

<p:forEach items="${empList}" var="emp">
<tr>

<td>${emp.employeeName}</td>
<td>${emp.employeeAddress}</td>
<td>${emp.employeePhone}</td>
<td>${emp.employeeSalary}</td>
<td><form action="editEmpById" method="get">
    <input type="hidden" name="id" value="${emp.id}" />
    <button type="submit">Update</button>
    </form></td> 
    
    <td><form action="deleteEmpById" method="get">
    <input type="hidden" name="id" value="${emp.id}" />
    <button type="submit">Delete</button>
    </form></td> 


</tr>
</p:forEach>

</table>
</body>
</html>