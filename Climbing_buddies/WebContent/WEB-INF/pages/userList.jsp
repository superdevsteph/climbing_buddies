<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
<style>
   table  {
       margin-top: 10px;
       border: solid black 1px;
   }
   table  td {
        padding: 5px;
   }
   .message  {
        font-size:90%;
        color:blue;
        font-style:italic;
        margin-top:30px;
   }
</style>
</head>
<body>
 
 
 
<a href="${pageContext.request.contextPath}/createUser">Create User</a>
 
<br/>
 
 
<table border="1">
 <tr>
   <th>Name</th>
   <th>Login</th>
   <th>Password</th>
   <th>Email</th>
   <th>Cotation</th>
   <th>Edit</th>
   <th>Delete</th>
 </tr>
 <c:forEach items="${userInfos}" var="info">
 
 <tr>
   <td> ${info.name}  </td>
   <td> ${info.login}  </td>
   <td> ${info.password} </td>
   <td> ${info.email} </td>
   <td> ${info.cotation} </td>
   <td> <a href="deleteUser?id=${info.id}">Delete</a> </td>
   <td> <a href="editUser?id=${info.id}">Edit</a> </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 
 
 
</body>
</html>