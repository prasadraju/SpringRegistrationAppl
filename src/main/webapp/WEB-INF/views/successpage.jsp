<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Success Page
</h1>

<P>  ${resultMsg} </P>

<a href="employee/employeelist">Get Employee data</a> <br> <br>

<div align="center">
            <h1>Employee List</h1>
           
            <table border="1">
                <th>No</th> <th>Name</th> <th>Email</th> <th>Address</th> <th>Telephone</th> <th>Action</th>
               
                <c:forEach var="emp" items="${emplist}" varStatus="status">
                <tr>
                    <td>${emp.EMP_ID}</td>
                    <td>${emp.EMP_NAME}</td>
                    <td>${emp.EMAIL}</td>
                    <td>${emp.ADDRESS}</td>
                    <td>${emp.PHONE}</td>
                    <td>
                        <a href="editEmployee?id=${emp.EMP_ID}">Edit</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteEmployee?id=${emp.EMP_ID}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>

</body>
</html>
