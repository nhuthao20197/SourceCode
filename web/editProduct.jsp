<%-- 
    Document   : editProduct
    Created on : Sep 29, 2016, 7:11:44 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="editproduct.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
       
        <h1>Edit Product</h1>
        <div class="ii">
            <form action="ControllerProducts">
            Code:${SP.code}<br/>
            <input type="hidden" name="txtCode" value="${SP.code}">
            <input type="text" placeholder="Name"  name="txtName" value="${SP.name}"/><br/>
            <input type="text" placeholder="Price" name="txtPrice" value="${SP.price}"/><br/>
            <input type="submit" name="action" value="Update"/>
               </form>

            
        </div>
        
         
    </body>
</html>
