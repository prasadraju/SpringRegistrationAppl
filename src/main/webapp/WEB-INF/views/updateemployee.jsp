
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Edit Employee Form
</h1>

<form:form  action="updateEmployee" method="post">
   <table>
   
   
    <tr>
        <td><form:label path="EMP_ID">ID</form:label></td>
        <td><form:input path="EMP_ID" /></td>
    </tr>
    <tr>
        <td><form:label path="EMP_NAME">Name</form:label></td>
        <td><form:input path="EMP_NAME" /></td>
    </tr>
    
    <tr>
        <td><form:label path="EMAIL">Email</form:label></td>
        <td><form:input path="EMAIL" /></td>
    </tr>
    
     <tr>
        <td><form:label path="ADDRESS">Address</form:label></td>
        <td><form:input path="ADDRESS" /></td>
    </tr>
    
    
    
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>

</body>
</html>
