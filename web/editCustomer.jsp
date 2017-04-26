<%-- 
    Document   : editCustomer
    Created on : Oct 18, 2016, 8:53:55 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="editproduct.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       <h1>Edit Customers</h1>
        
            <form action="ControllerCustomers">
                <div class="ii">
                    
                     Code:${Cus.username}<br/>
                     <input type="hidden" placeholder="Username" name="txtUsername" value="${Cus.username}">
                     <input type="text" placeholder="Password" name="txtPassword" value="${Cus.password}"/><br/>
                     <input type="text" placeholder="Hoten" name="txtHoten" value="${Cus.hoten}"/><br/>
                     <input type="text" placeholder="Gioitinh" name="txtGioitinh" value="${Cus.gioitinh}"/><br/>
                     <input type="text" placeholder="Email" name="txtEmail" value="${Cus.email}"/><br/>
                     <input type="text" placeholder="Role" name="txtRole" value="${Cus.role}"/><br/>
                <input type="submit" name="action" value="Update"/>
                </div>
                      </form>

                
                    
       
    </body>
</html>
