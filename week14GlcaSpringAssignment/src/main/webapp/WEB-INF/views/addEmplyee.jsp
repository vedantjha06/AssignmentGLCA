<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
<style>
body {
    text-align: center;
    background-color: pink;
}

table
{
	margin: auto;
	width: 35%;
}


</style>
</head>
<body>

<form:form modelAttribute="emp" action="processEmp" method="get">
    <table border="2">
    
    <tr >
            <td colspan="2"><form:hidden path="id"/>Add Employee Details</td>
            
        </tr>
        
        <tr>
            <td>Employee Name: </td>
            <td><form:input path="employeeName" /></td>
        </tr>
        <tr>
            <td>Employee Address: </td>
            <td><form:input path="employeeAddress" /></td>
        </tr>
        <tr>
            <td>Employee Salary: </td>
            <td><form:input path="employeeSalary" /></td>
        </tr>
        <tr>
            <td>Employee Phone: </td>
            <td><form:input path="employeePhone" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
            <td><input type="reset" value="Reset"/></td>
        </tr>
    
    
       
    </table>
</form:form>

</body>
</html>