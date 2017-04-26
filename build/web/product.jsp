<%-- 
    Document   : product.jsp
    Created on : Sep 26, 2016, 8:16:27 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="product.css" rel="stylesheet" type="text/css"/>
    
    </head>
    <body>
       
       <h1>Products</h1>
        
        <div id="id">
            
        <div class="ii">
            <form action="ControllerProducts">
            Nhap ten SP:<input type="text" name="txtTenSP" value=""/>
            <input type="submit" name="action" value="Search"/>
            <input type="submit" name="action" value="Add"/>
        </form>
            
        </div>
           
        <div class="aa">
            <form  action="ControllerProducts">
              <table border="1">
                <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Price</td>
            </tr>
     
            <c:forEach var="rows" items="${listSP}">
             
               <tr>
                    <td>${rows.code}</td>
                    <td>${rows.name}</td>
                    <td>${rows.price}</td>
                    <c:url var="del"  value="ControllerProducts">
                        <c:param name="action" value="Edit"/>
                        <c:param name="txtCode" value="${rows.code}"/>
                        <c:param name="txtName" value="${rows.name}"/>
                        <c:param name="txtPrice" value="${rows.price}"/>
                        
                    </c:url>
                    <td><a href="${del}">Edit</a></td>
                    <td>
                        <input type="hidden" name="txtCode" value="${rows.code}"/>
                        <input type="submit" name="action" value="Delete"/>
                    </td>
            
                </tr>
             s
            </c:forEach>
            </table>
            </form>
        </div>
        </div>
       
       
        </body>
</html>
