<%-- 
    Document   : CustomerDAO
    Created on : Oct 12, 2016, 11:06:50 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="dao.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <div id="id">
            <div <div class="ii">
                <form action="ControllerCustomers">
                Ten: <input type="text" name="txtname">
               <input type="submit" name="action" value="Search">
                <input type="submit" name="action" value="Add"/>
            
        </form>
                </div>
                < <div class="aa">
                       <table border="1">
            
                <tr>
                <td>Username</td>
                 <td>pass</td>
                <td>Name</td>
                 <td>gioitinh</td>
                <td>email</td>
                 <td>role</td>
            </tr>
            <c:forEach var="rows" items="${listKH}">
             
               <tr>
                   <td><input type="text" value="${rows.username}" name="txtUserName"></td>
                   <td><input type="text" value="${rows.password}" name="txtPassword"></td>
                   <td><input type="text" value="${rows.hoten}" name="txtHoten"></td>
                   <td><input type="text" value="${rows.gioitinh}" name="txtGioitinh"></td>
                   <td><input type="text" value="${rows.email}" name="txtEmail"></td>
                   <td><input type="text" value="${rows.role}" name="txtRole"></td>
                <c:url var="del"  value="ControllerCustomers">
                        <c:param name="action" value="Edit"/>
                        <c:param name="txtUsername" value="${rows.username}"/>
                        <c:param name="txtPassword" value="${rows.password}"/>
                        <c:param name="txtHoten" value="${rows.hoten}"/>
                        <c:param name="txtGioitinh" value="${rows.gioitinh}"/>
                        <c:param name="txtEmail" value="${rows.email}"/>
                        <c:param name="txtRole" value="${rows.role}"/>
                        
                    </c:url>
                    <td><a href="${del}">Edit</a></td>
                    <td>
                        <form action="ControllerCustomers">
                        <input type="hidden" name="txtCode" value="${rows.username}"/>
                        
                        <input type="submit" name="action" value="Delete"/>
                        </form>
                    </td>
               
            </tr>
               </c:forEach>
            
        </table>
                </div>
     
        </div>
        
    </body>
</html>
