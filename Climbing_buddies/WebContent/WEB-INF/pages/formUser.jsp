<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
<style>
.error-message {
   color: red;
   font-size:90%;
   font-style: italic;
}
</style>
</head>
<body>
 
   <h3>${formTitle}</h3>
 
   <form:form action="saveUser" method="POST"
       modelAttribute="userForm">
 
       <form:hidden path="id" />
 
       <table>
           <tr>
               <td>Name</td>
               <td><form:input path="name" /></td>
               <td><form:errors path="name"
                       class="error-message" /></td>      
           </tr>
           <tr>
               <td>Password</td>
               <td><form:input path="password" /></td>
               <td><form:errors path="password"
                       class="error-message" /></td>    
           </tr>
           <tr>
               <td>Email</td>
               <td><form:input path="email" /></td>
               <td><form:errors path="email" class="error-message" /></td>
           </tr>
           <tr>
           <td>Login</td>
               <td><form:input path="login" /></td>
               <td><form:errors path="login"
                       class="error-message" /></td>      
               
           </tr>
 
           <tr>
               <td>Cotation</td>
               <td><form:input path="cotation" /></td>
               <td><form:errors path="cotation"
                       class="error-message" /></td>    
           </tr>
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/userList">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
   </form:form>
 
</body>
</html>